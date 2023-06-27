package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Compra request dto
 */
public class PurchaseRequestDto {

    private Integer numberBill;
    private String cardIdCustomer;
    private LocalDateTime date;
    private Double total;
    private String paymentMethod;
    private List<CarPurchaseRequestDto> carsPurchase;

    public Integer getNumberBill() {
        return numberBill;
    }

    public void setNumberBill(Integer numberBill) {
        this.numberBill = numberBill;
    }

    public String getCardIdCustomer() {
        return cardIdCustomer;
    }

    public void setCardIdCustomer(String cardIdCustomer) {
        this.cardIdCustomer = cardIdCustomer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<CarPurchaseRequestDto> getCarsPurchase() {
        return carsPurchase;
    }

    public void setCarsPurchase(List<CarPurchaseRequestDto> carsPurchase) {
        this.carsPurchase = carsPurchase;
    }
}
