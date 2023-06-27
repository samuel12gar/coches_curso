package com.project.coches.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;

@Embeddable
public class CarPurchasePK implements Serializable {


    @Column(name = "compras_numero_factura")
    private Integer purchaseNumberBill;

    @Column(name = "coches_codigo_coche")
    private Integer codeCar;

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
}
