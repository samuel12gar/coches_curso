package com.project.coches.domain.repository;

import com.project.coches.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface de customer
 */
public interface ICustomerRepository {

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
     * @param newCustomer Marca coche a guardar
     * @return Marca coche guardada
     */
    CustomerDto save(CustomerDto newCustomer);

    /**
     * Elimina un cliente dado su cardId
     * @param cardId cardId cliente
     */
    void delete(String cardId);
}
