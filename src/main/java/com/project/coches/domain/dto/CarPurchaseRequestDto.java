package com.project.coches.domain.dto;

/**
 * Carro compra request dto
 */
public class CarPurchaseRequestDto {

    private Integer purchaseNumberBill;
    private Integer codeCar;
    private Integer quantity;
    private Integer total;

    public Integer getPurchaseNumberBill() {
        return purchaseNumberBill;
    }

    public void setPurchaseNumberBill(Integer purchaseNumberBill) {
        this.purchaseNumberBill = purchaseNumberBill;
    }

    public Integer getCodeCar() {
        return codeCar;
    }

    public void setCodeCar(Integer codeCar) {
        this.codeCar = codeCar;
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
