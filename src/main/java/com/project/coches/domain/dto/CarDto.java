package com.project.coches.domain.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {

    private Integer codeCar;
    private Integer brandCar;
    private String reference;
    private Double price;
    private Double modelYear;
    private String color;
    private String horsePower;
    private Integer numberDoor;
    private Double engineDisplacement;
    private String transmission;
    private String fuelType;
    private Integer numberSeat;
    private Integer traction;
    private String steering;
    private String category;
    private String imagePath;

}
