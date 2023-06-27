package com.project.coches.domain.dto;

public class PurchaseBillResponseDto {

    private Integer numberBill;

    public PurchaseBillResponseDto(Integer numberBill) {
        this.numberBill = numberBill;
    }

    public Integer getNumberBill() {
        return numberBill;
    }

    public void setNumberBill(Integer numberBill) {
        this.numberBill = numberBill;
    }
}
