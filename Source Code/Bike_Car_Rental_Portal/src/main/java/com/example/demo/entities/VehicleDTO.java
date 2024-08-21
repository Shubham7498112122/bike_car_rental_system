package com.example.demo.entities;

public class VehicleDTO {
    private int registrationNumber;
    private int buyingYear;
    private String brandName;
    private String categoryName;
    private String modelName;
    private int charges;

    public VehicleDTO() {
    }

    public VehicleDTO(int registrationNumber, int buyingYear, String brandName, String categoryName, String modelName, int charges) {
        this.registrationNumber = registrationNumber;
        this.buyingYear = buyingYear;
        this.brandName = brandName;
        this.categoryName = categoryName;
        this.modelName = modelName;
        this.charges = charges;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getBuyingYear() {
        return buyingYear;
    }

    public void setBuyingYear(int buyingYear) {
        this.buyingYear = buyingYear;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "registrationNumber=" + registrationNumber +
                ", buyingYear=" + buyingYear +
                ", brandName='" + brandName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", charges=" + charges +
                '}';
    }
}
