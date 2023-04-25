package com.project.coches.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class CarPurchasePK {

    @Id
    @Column(name = "compras_numero_factura")
    private Integer purchaseNumberBill;
    @Id
    @Column(name = "coches_codigo_coche")
    private Integer codeCar;
}
