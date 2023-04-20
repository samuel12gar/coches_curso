package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto de un cliente
 */
@Getter @Setter
public class CustomerDto {

    private String cardId;

    private String fullName;

    private String email;

    private Double numberCellPhone;

    private Integer active;

    private String password;

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
}
