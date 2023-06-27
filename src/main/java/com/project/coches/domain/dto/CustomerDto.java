package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto de un cliente
 */
public class CustomerDto {

    private String cardId;

    private String fullName;

    private String email;

    private Double numberCellPhone;

    private Integer active;

    private String password;

    private String rol;
    @Override
    public String toString() {
        return "CustomerDto{" +
                "cardId='" + cardId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", numberCellPhone=" + numberCellPhone +
                ", active=" + active +
                ", password='" + password + '\'' +
                '}';
    }

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
