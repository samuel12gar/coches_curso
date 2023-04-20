package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.repository.IBrandCarRepository;
import com.project.coches.persistance.entity.BrandCarEntity;
import com.project.coches.persistance.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de marca coche
 */
@RequiredArgsConstructor // crea constructor con los atributos final
@Repository
public class BrandCarRepository implements IBrandCarRepository {

    /**
     * crud marca coche
     */
    private final IBrandCarCrudRepository iBrandCarCrudRepository;
    /**
     * mapper de marca coche
     */
    private final IBrandCarMapper iBrandCarMapper;

    /**
     * Devuelve lista marca coches pojo
     * @return Lista marca coches pojos
     */
    @Override
    public List<BrandCarDto> getAll() {
        return iBrandCarMapper.toMarcasCocheDto(iBrandCarCrudRepository.findAll());
    }

    /**
     * Devuelve un opcional marca coche pojo
      * @param id Id de marca coche
     * @return Optional marca coche pojo
     */
    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        return iBrandCarCrudRepository.findById(id).
            map(iBrandCarMapper::toMarcaCocheDto);
            //map(brandCarEntity -> iBrandCarMapper.toMarcaCochePojo(brandCarEntity));
    }

    /**
     * Devuelve marca coche pojo
     * @param newBrandCar Marca coche a guardar
     * @return BrandCarPojo
     */
    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        BrandCarEntity brandCarEntity = iBrandCarMapper.toMarcaCocheEntity(newBrandCar);
        return iBrandCarMapper.toMarcaCocheDto(iBrandCarCrudRepository.save(brandCarEntity));
    }

    /**
     * Borra un marca coche por id
     * @param id Id de la marca coche a eliminar
     */
    @Override
    public void delete(Integer id) {
        iBrandCarCrudRepository.deleteById(id);
    }
}
