package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "starting_date", nullable = false, length = 20)
    private String startingDate;

    @Column(name = "booking_date", nullable = false, length = 20)
    private String bookingDate;

    @Column(name = "end_date", nullable = false, length = 20)
    private String endDate;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    // Getters and setters
    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public String getStartingDate() { return startingDate; }
    public void setStartingDate(String startingDate) { this.startingDate = startingDate; }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    
    public Booking() {}

    public Booking(String startingDate, String bookingDate, String endDate, String status, Customer customer, Vehicle vehicle) {
        this.startingDate = startingDate;
        this.bookingDate = bookingDate;
        this.endDate = endDate;
        this.status = status;
        this.customer = customer;
        this.vehicle = vehicle;
    }
}

