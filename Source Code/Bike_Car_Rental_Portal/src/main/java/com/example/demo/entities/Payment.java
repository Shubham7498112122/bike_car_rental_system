package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @Column(name = "payment_date", nullable = false, length = 20)
    private String paymentDate;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "payment_method", nullable = false, length = 20)
    private String paymentMethod;
    
    @Column(name="status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    // Getters and setters
    public int getPaymentId() { return paymentId; }
    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }

    public String getPaymentDate() { return paymentDate; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public Booking getBooking() { return booking; }
    public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setBooking(Booking booking) { this.booking = booking; }

    // Constructors
    public Payment() {}

    public Payment(String paymentDate, int amount, String paymentMethod, Booking booking) {
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.booking = booking;
    }
}
