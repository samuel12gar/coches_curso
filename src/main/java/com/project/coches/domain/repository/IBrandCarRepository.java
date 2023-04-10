package com.project.coches.domain.repository;

import com.project.coches.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository {

    /**
     * Devuelve una lista con todos las marcas de coches
     * @return Lista con marcas de coches
     */
    List<BrandCarPojo> getAll();

    /**
     * Devuelve una marca de coche dado su id
     * @param id Id de marca coche
     * @return Optional de marca de coche encontrado
     */
    Optional<BrandCarPojo> getBrandCar(Integer id);

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guardada
     */
    BrandCarPojo save(BrandCarPojo newBrandCar);

    /**
     * Elimina una marca coche dado su id
     * @param id Id de la marca coche a eliminar
     */
    void delete(Integer id);
}
