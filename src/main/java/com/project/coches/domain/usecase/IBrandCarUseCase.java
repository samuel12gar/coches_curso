package com.project.coches.domain.usecase;

import com.project.coches.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCarUseCase {

    /**
     * Devuelve una lista con todos las marcas de coches
     * @return Lista con marcas de coches
     */
    List<BrandCarDto> getAll();

    /**
     * Devuelve una marca de coche dado su id
     * @param id Id de marca coche
     * @return Optional de marca de coche encontrado
     */
    Optional<BrandCarDto> getBrandCar(Integer id);

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guardada
     */
    BrandCarDto save(BrandCarDto newBrandCar);

    /**
     * Actualiza una marca coche
     * @param updateBrandCarDto marca coche a actualizar
     * @return Marca coche actualizado
     */
    Optional<BrandCarDto> update(BrandCarDto updateBrandCarDto);
    /**
     * Elimina una marca coche dado su id
     * @param id Id de la marca coche a eliminar
     */
    boolean delete(Integer id);
}
