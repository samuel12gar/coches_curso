package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;
import java.util.List;

/**
 * Entidad de un cliente
 */
//@Getter @Setter
@Entity
@Table(name = "cliente")
public class CustomerEntity implements Serializable {

    @Id
    @Column(name = "cedula")
    private String cardId;

    @Column(name = "nombre_completo")
    private String fullName;

    @Column(name = "correo")
    private String email;

    @Column(name = "numero_celular")
    private Double numberCellPhone;

    @Column(name = "activo")
    private Integer active;

    @Column(name = "contrasenia")
    private String password;

    @OneToMany(mappedBy = "customerEntity")
    private List<PurchaseEntity> purchaseEntity;


    private String rol;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getNumberCellPhone() {
        return numberCellPhone;
    }

    public void setNumberCellPhone(Double numberCellPhone) {
        this.numberCellPhone = numberCellPhone;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PurchaseEntity> getPurchaseEntity() {
        return purchaseEntity;
    }

    public void setPurchaseEntity(List<PurchaseEntity> purchaseEntity) {
        this.purchaseEntity = purchaseEntity;
    }


    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "cardId='" + cardId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", numberCellPhone=" + numberCellPhone +
                ", active=" + active +
                ", password='" + password + '\'' +
                ", purchaseEntity=" + purchaseEntity +
                ", rol='" + rol + '\'' +
                '}';
    }
}
