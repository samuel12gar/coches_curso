package com.project.coches.domain.dto;

/**
 * Carro compra respuesta dto
 */
public class CarPurchaseResponseDto {

    private String referenceCar;
    private Integer quantity;
    private Integer total;

    public CarPurchaseResponseDto(String referenceCar, Integer quantity, Integer total) {
        this.referenceCar = referenceCar;
        this.quantity = quantity;
        this.total = total;
    }

    public String getReferenceCar() {
        return referenceCar;
    }

    public void setReferenceCar(String referenceCar) {
        this.referenceCar = referenceCar;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
