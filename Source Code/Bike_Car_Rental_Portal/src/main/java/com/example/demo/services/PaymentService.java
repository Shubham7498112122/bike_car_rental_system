package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Payment;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Payment createPayment(Payment payment) throws Exception {
        Booking booking = bookingRepository.findById(payment.getBooking().getBookingId())
                .orElseThrow(() -> new Exception("Booking not found"));

        payment.setBooking(booking);
        return paymentRepository.save(payment);
    }
}
