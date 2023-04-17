package com.project.coches.domain.service;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.repository.IBrandCarRepository;
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
    public List<BrandCarDto> getAll() {
        return iBrandCarRepository.getAll();
    }

    /**
     * Devuelve un optional marca coche pojo
     * @param id Id de marca coche
     * @return Optional Marca Coche pojo
     */
    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    /**
     * Guarda marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Guardado marca coche
     */
    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        return iBrandCarRepository.save(newBrandCar);
    }

    /**
     *
     * @param updateBrandCarDto marca coche a actualizar
     * @return
     */
    public Optional<BrandCarDto> update(BrandCarDto updateBrandCarDto){
       if(iBrandCarRepository.getBrandCar(updateBrandCarDto.getId()).isEmpty()){
           return Optional.empty();
       }
       return Optional.of(iBrandCarRepository.save(updateBrandCarDto));
    }
    /**
     * Borra marca coche
     * @param id Id de la marca coche a eliminar
     * @return true o false eliminado marca coche
     */
    @Override
    public boolean delete(Integer id) {
        if(iBrandCarRepository.getBrandCar(id).isEmpty()){
            return false;
        }
        iBrandCarRepository.delete(id);
        return true;
    }
}
