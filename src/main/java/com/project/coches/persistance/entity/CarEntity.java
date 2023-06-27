package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "coches")
public class CarEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_coche")
    private Integer codeCar;

    @Column(name = "marca_coche_id")
    private Integer brandCarId;

    @Column(name = "referencia")
    private String reference;

    @Column(name = "precio")
    private Double price;

    @Column(name = "anio_modelo")
    private Double modelYear;

    private String color;

    @Column(name = "numero_caballos_fuerza")
    private String horsePower;

    @Column(name = "cantidad_puertas")
    private Integer numberDoor;

    @Column(name = "cilindraje")
    private Double engineDisplacement;

    @Column(name = "transmision")
    private String transmission;

    @Column(name = "tipo_combustible")
    private String fuelType;

    @Column(name = "cantidad_asientos")
    private Integer numberSeats;

    @Column(name = "traccion")
    private Integer traction;

    @Column(name = "direccion")
    private String steering;

    @Column(name = "categoria")
    private String category;

    @Column(name = "ruta_imagen")
    private String imagePath;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "marca_coche_id", insertable = false, updatable = false)
    private BrandCarEntity brandCarEntity;

    @OneToMany(mappedBy = "carEntity")
    private List<CarPurchaseEntity> carPurchaseEntity;

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

    public BrandCarEntity getBrandCarEntity() {
        return brandCarEntity;
    }

    public void setBrandCarEntity(BrandCarEntity brandCarEntity) {
        this.brandCarEntity = brandCarEntity;
    }

    public List<CarPurchaseEntity> getCarPurchaseEntity() {
        return carPurchaseEntity;
    }

    public void setCarPurchaseEntity(List<CarPurchaseEntity> carPurchaseEntity) {
        this.carPurchaseEntity = carPurchaseEntity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "codeCar=" + codeCar +
                //", brandCar=" + brandCar +
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
                ", brandCarEntity=" + brandCarEntity +
                ", carPurchaseEntity=" + carPurchaseEntity +
                '}';
    }
}
