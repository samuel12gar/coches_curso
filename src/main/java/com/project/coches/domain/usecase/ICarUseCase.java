package com.project.coches.domain.usecase;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICarUseCase {

    /**
     * Devuelve una lista de los coches
     * @return Lista de coches
     */
    List<CarDto> getAll();

    /**
     * Devuelve una lista de los coches por marca
     * @param idBrandCar id marca de coches
     * @return Lista de coches de una marca
     */
    List<CarDto> getByIdBrandCar(Integer idBrandCar);

    /**
     * Devuelve una lista de los coches de un precio tal
     * @param price precio de coches
     * @return Lista de coches de un precio
     */
    List<CarDto> findAllByPriceLessThanOrderByPriceDesc(Double price);

    /**
     * Devuelve un coche dado su idCar
     * @param idCar id car del coche
     * @return Optional de coche encontrado
     */
    Optional<CarDto> getCar(Integer idCar);

    /**
     * Guarda un nuevo coche
     * @param newCar coche a guardar
     * @return Coche guardado
     */
    CarDto save(CarDto newCar);

    /**
     * Elimina un coche dado su idCar
     * @param idCar idcar coche
     * @return devuelve true se elimino de lo contrario fallo el borrado
     */
    boolean delete(Integer idCar);

    Optional<CarDto> update(CarDto updateCarDto);
}
