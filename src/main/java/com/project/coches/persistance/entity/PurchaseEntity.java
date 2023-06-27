package com.project.coches.persistance.entity;

import com.project.coches.domain.dto.CarPurchaseRequestDto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Entity compra
 */
@Entity
@Table(name = "compras")
public class PurchaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_factura")
    private Integer numberBill;

    @Column(name = "cliente_cedula")
    private String cardIdCustomer;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    private Double total;

    @Column(name = "medio_pago")
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "cliente_cedula", insertable = false, updatable = false)
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "purchaseEntity", cascade = CascadeType.ALL )
    private List<CarPurchaseEntity> carsPurchase;

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

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public List<CarPurchaseEntity> getCarsPurchase() {
        return carsPurchase;
    }

    public void setCarsPurchase(List<CarPurchaseEntity> carsPurchase) {
        this.carsPurchase = carsPurchase;
    }
}
