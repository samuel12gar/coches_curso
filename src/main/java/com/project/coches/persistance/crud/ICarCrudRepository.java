package com.project.coches.persistance.crud;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.persistance.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarCrudRepository extends JpaRepository<CarEntity,Integer> {

    //query methods
    List<CarEntity> findAllByBrandCar(Integer idBrandCarId);

    List<CarEntity> findAllByPriceLessThanOrderByPriceDesc(Double price);

}
