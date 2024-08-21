package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 100)
    private String phoneNumber;

    @Column(name = "driving_licence_no")
    private String drivingLincenceNo;

    @Column(name = "aadhar_number", nullable = false, length = 100, unique = true)
    private String aadharNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Login login;

    // Getters and setters
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getDrivingLincenceNo() { return drivingLincenceNo; }
    public void setDrivingLincenceNo(String drivingLincenceNo) { this.drivingLincenceNo = drivingLincenceNo; }

    public String getAadharNumber() { return aadharNumber; }
    public void setAadharNumber(String aadharNumber) { this.aadharNumber = aadharNumber; }

    public Login getUser() { return login; }
    public void setUser(Login user) { this.login = user; }

    // Constructors
    public Customer() {}

    public Customer(String name, String email, String phoneNumber, String drivingLincenceNo, String aadharNumber,Login login) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.drivingLincenceNo = drivingLincenceNo;
        this.aadharNumber = aadharNumber;
        this.login = login;
    }
}

