package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private int modelId;

    @Column(name = "model_name", nullable = false, length = 100)
    private String modelName;

    @Column(name = "charges", nullable = false)
    private int charges;
    
    @Column(name="capacity", nullable = false)
    private String capacity;
    
    @Column(name="image", nullable = false)
    private String image;
    
    @Column(name="fuel_type", nullable = false)
    private String fuelType;

    public String getImage() {
		return image;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public void setImage(String image) {
		this.image = image;
	}

	@ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    // Getters and setters
    public int getModelId() { return modelId; }
    public void setModelId(int modelId) { this.modelId = modelId; }

    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }

    public int getCharges() { return charges; }
    public void setCharges(int charges) { this.charges = charges; }

    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }
    
    public String getCapacity() {
    	return capacity;
    }
    
    public void setCapacity(String capacity) {
    	this.capacity=capacity;
    }

    public Model() {}

    public Model(String modelName, int charges, Brand brand,String capacity) {
        this.modelName = modelName;
        this.charges = charges;
        this.brand = brand;
        this.capacity=capacity;
    }
}
