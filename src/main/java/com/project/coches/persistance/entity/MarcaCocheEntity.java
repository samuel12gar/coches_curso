package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad de la marca coche
 */
@Entity
@Table(name = "marca_coche")
@Getter @Setter
public class MarcaCocheEntity {

    /**
     *  id de la marca coche
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * descripcion de la marca coche
     */
    @Column(name = "descripcion")
    private String descripcion;


}
