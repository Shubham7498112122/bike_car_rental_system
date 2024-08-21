package com.example.demo.controller;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Vehicle;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.VehicleRepository;
import com.example.demo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {

    @Autowired
    private final BookingService bookingService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/by-customer")
    public List<Booking> getBookingsByCustomerId(@RequestParam int customerId) {
        return bookingService.getBookingsByCustomerId(customerId);
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        try {
            Customer customer = customerRepository.findById(booking.getCustomer().getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));//finding customer is present or not

            Vehicle vehicle = vehicleRepository.findById(booking.getVehicle().getVehicleId())
                    .orElseThrow(() -> new RuntimeException("Vehicle not found"));// finding vehicle is present or not

            booking.setCustomer(customer);//calling getter method
            booking.setVehicle(vehicle);

            Booking savedBooking = bookingService.saveBooking(booking);

            return ResponseEntity.ok(savedBooking);// return status as ok and saving bookings.
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating booking: " + e.getMessage());
        }
    }
}
