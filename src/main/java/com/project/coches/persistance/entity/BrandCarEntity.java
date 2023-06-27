package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.List;

/**
 * Entidad de la marca coche
 */
@Entity
@Table(name = "marca_coche")
//@Getter @Setter
public class BrandCarEntity implements Serializable {

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

    //orphanRemoval = true
    @OneToMany(mappedBy = "brandCarEntity")
    private List<CarEntity> carEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<CarEntity> getCarEntities() {
        return carEntities;
    }

    public void setCarEntities(List<CarEntity> carEntities) {
        this.carEntities = carEntities;
    }

    @Override
    public String toString() {
        return "BrandCarEntity{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", carEntities=" + carEntities +
                '}';
    }
}
