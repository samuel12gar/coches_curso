package com.project.coches.domain.service;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.repository.IBrandCarRepository;
import com.project.coches.persistance.repository.IBrandCarCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de marca coche
 */
@RequiredArgsConstructor
@Service
public class BrandCarService implements IBrandCarService{

    /**
     * repositorio de marca coche
     */
    private final IBrandCarRepository iBrandCarRepository;

    /**
     * devuelve todos los marca coche pojos
     * @return List marca coches pojo
     */
    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarRepository.getAll();
    }

    /**
     * Devuelve un optional marca coche pojo
     * @param id Id de marca coche
     * @return Optional Marca Coche pojo
     */
    @Override
    public Optional<BrandCarPojo> getBrandCar(Integer id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    /**
     * Guarda marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Guardado marca coche
     */
    @Override
    public BrandCarPojo save(BrandCarPojo newBrandCar) {
        return iBrandCarRepository.save(newBrandCar);
    }

    /**
     * Borra marca coche
     * @param id Id de la marca coche a eliminar
     * @return true o false eliminado marca coche
     */
    @Override
    public boolean delete(Integer id) {
        try{
            iBrandCarRepository.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
