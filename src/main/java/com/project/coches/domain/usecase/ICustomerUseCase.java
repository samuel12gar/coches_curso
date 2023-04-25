package com.project.coches.domain.usecase;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerUseCase {

    /**
     * Devuelve una lista de los clientes
     * @return Lista clientes
     */
    List<CustomerDto> getAll();

    /**
     * Devuelve un cliente dado su cardId
     * @param cardId card id de cliente
     * @return Optional de cliente encontrado
     */
    Optional<CustomerDto> getCustomerByCardId(String cardId);

    /**
     * Devuelve un cliente dado email
     * @param email email de cliente
     * @return Optional de cliente encontrado por su email
     */
    Optional<CustomerDto> getCustomerByEmail(String email);

    /**
     * Guarda un nuevo cliente
     * @param newCustomer cliente a guardar
     * @return Cliente guardado
     */
    ResponseCustomerDto save(CustomerDto newCustomer);

    Optional<CustomerDto> update(CustomerDto updateCustomerDto);
    /**
     * Elimina un cliente dado su cardId
     * @param cardId cardId cliente
     */
    boolean delete(String cardId);
}
