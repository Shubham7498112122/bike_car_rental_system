package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private int vehicleId;

    @Column(name="status")
    private String status;
    
    public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "buying_year", nullable = false)
    private int buyingYear;
    

    @Column(name = "registration_number", nullable = false, unique = true)
    private int registrationNumber;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    // Getters and setters
    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public int getBuyingYear() { return buyingYear; }
    public void setBuyingYear(int buyingYear) { this.buyingYear = buyingYear; }

    public int getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(int registrationNumber) { this.registrationNumber = registrationNumber; }

    public Model getModel() { return model; }
    public void setModel(Model model) { this.model = model; }

    public Owner getOwner() { return owner; }
    public void setOwner(Owner owner) { this.owner = owner; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Vehicle() {}
	public Vehicle(int vehicleId, int buyingYear, int registrationNumber, Model model, Owner owner, Category category,String status) {
		this.vehicleId = vehicleId;
		this.buyingYear = buyingYear;
		this.registrationNumber = registrationNumber;
		this.model = model;
		this.owner = owner;
		this.category = category;
		this.status=status;
	}

}
