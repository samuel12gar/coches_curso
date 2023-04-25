package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.repository.ICarRepository;
import com.project.coches.persistance.crud.ICarCrudRepository;
import com.project.coches.persistance.entity.CarEntity;
import com.project.coches.persistance.entity.CustomerEntity;
import com.project.coches.persistance.mapper.ICarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CarRepository implements ICarRepository {

    private final ICarCrudRepository iCarCrudRepository;
    private final ICarMapper iCarMapper;

    @Override
    public List<CarDto> getAll() {
        return iCarMapper.toCarsDto(iCarCrudRepository.findAll());
    }

    @Override
    public List<CarDto> getByIdBrandCar(Integer idBrandCar) {

        return iCarMapper.toCarsDto(iCarCrudRepository.findAllByBrandCar(idBrandCar));
    }

    @Override
    public List<CarDto> findAllByPriceLessThanOrderByPriceDesc(Double price) {
        return iCarMapper.toCarsDto(iCarCrudRepository.findAllByPriceLessThanOrderByPriceDesc(price));
    }

    @Override
    public Optional<CarDto> getCar(Integer idCar) {
        return iCarCrudRepository.findById(idCar).
                map(iCarMapper::toCarDto);
    }

    @Override
    public CarDto save(CarDto newCar) {
        CarEntity carEntity = iCarMapper.toCarEntity(newCar);
        return iCarMapper.toCarDto(iCarCrudRepository.save(carEntity));
    }

    @Override
    public void delete(Integer idCar) {
        iCarCrudRepository.deleteById(idCar);
    }
}
