package com.project.coches.domain.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

public class CarDto {

    private Integer codeCar;
    //private BrandCarDto brandCarDto;
    private Integer brandCarId;
    private String brandCarString;
    private String reference;
    private Double price;
    private Double modelYear;
    private String color;
    private String horsePower;
    private Integer numberDoor;
    private Double engineDisplacement;
    private String transmission;
    private String fuelType;
    private Integer numberSeats;
    private Integer traction;
    private String steering;
    private String category;
    private String imagePath;
    private Integer stock;

    public Integer getCodeCar() {
        return codeCar;
    }

    public void setCodeCar(Integer codeCar) {
        this.codeCar = codeCar;
    }

    public Integer getBrandCarId() {
        return brandCarId;
    }

    public void setBrandCarId(Integer brandCarId) {
        this.brandCarId = brandCarId;
    }

    /*public BrandCarDto getBrandCarDto() {
        return brandCarDto;
    }

    public void setBrandCarDto(BrandCarDto brandCarDto) {
        this.brandCarDto = brandCarDto;
    }*/

    public String getBrandCarString() {
        return brandCarString;
    }

    public void setBrandCarString(String brandCarString) {
        this.brandCarString = brandCarString;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getModelYear() {
        return modelYear;
    }

    public void setModelYear(Double modelYear) {
        this.modelYear = modelYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }

    public Integer getNumberDoor() {
        return numberDoor;
    }

    public void setNumberDoor(Integer numberDoor) {
        this.numberDoor = numberDoor;
    }

    public Double getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(Double engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(Integer numberSeats) {
        this.numberSeats = numberSeats;
    }

    public Integer getTraction() {
        return traction;
    }

    public void setTraction(Integer traction) {
        this.traction = traction;
    }

    public String getSteering() {
        return steering;
    }

    public void setSteering(String steering) {
        this.steering = steering;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "codeCar=" + codeCar +
                //", brandCarDto=" + brandCarDto +
                ", brandCarString='" + brandCarString + '\'' +
                ", reference='" + reference + '\'' +
                ", price=" + price +
                ", modelYear=" + modelYear +
                ", color='" + color + '\'' +
                ", horsePower='" + horsePower + '\'' +
                ", numberDoor=" + numberDoor +
                ", engineDisplacement=" + engineDisplacement +
                ", transmission='" + transmission + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", numberSeats=" + numberSeats +
                ", traction=" + traction +
                ", steering='" + steering + '\'' +
                ", category='" + category + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", stock=" + stock +
                '}';
    }
}
