package com.project.coches.persistance.entity;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * Entity coches_compra
 */
@Entity
@Table(name = "coches_compras")
public class CarPurchaseEntity implements Serializable {

    @EmbeddedId
    private CarPurchasePK id;

    @Column(name = "cantidad")
    private Integer quantity;
    private Integer total;

    @ManyToOne
    @MapsId(value = "purchaseNumberBill")
    @JoinColumn(name = "compras_numero_factura", insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;

    @ManyToOne
    @JoinColumn(name = "coches_codigo_coche", insertable = false, updatable = false)
    private CarEntity carEntity;

    public CarPurchasePK getId() {
        return id;
    }

    public void setId(CarPurchasePK id) {
        this.id = id;
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

    public PurchaseEntity getPurchaseEntity() {
        return purchaseEntity;
    }

    public void setPurchaseEntity(PurchaseEntity purchaseEntity) {
        this.purchaseEntity = purchaseEntity;
    }

    public CarEntity getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(CarEntity carEntity) {
        this.carEntity = carEntity;
    }
}
