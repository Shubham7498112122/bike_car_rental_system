package com.example.demo.services;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Vehicle;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private final BookingRepository bookingRepository;

    @Autowired
    private final VehicleRepository vehicleRepository;

    public BookingService(BookingRepository bookingRepository, VehicleRepository vehicleRepository) {
        this.bookingRepository = bookingRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public Booking saveBooking(Booking booking) {
        // Update vehicle status to "booked"
        Vehicle vehicle = vehicleRepository.findById(booking.getVehicle().getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        vehicle.setStatus("booked");

        // Save the vehicle first
        vehicleRepository.save(vehicle);

        // Save the booking
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByCustomerId(int customerId) {
        return bookingRepository.findByCustomer_CustomerId(customerId);
    }

    @Scheduled(cron = "0 0 0 * * ?") // Runs every day at midnight
    public void updateBookingStatuses() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currentDate = LocalDate.now();

        List<Booking> bookings = bookingRepository.findAll();

        for (Booking booking : bookings) {
            LocalDate endDate = LocalDate.parse(booking.getEndDate(), formatter);
            if (currentDate.isAfter(endDate)) {
                if (!"open".equals(booking.getStatus())) {
                    booking.setStatus("open");
                    bookingRepository.save(booking);
                }
            }
        }
    }
    public List<Booking> getBookingsByOwner(Integer ownerId) {
        return bookingRepository.findByOwnerId(ownerId);
    }
}
