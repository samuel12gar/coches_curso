package com.project.coches.domain.service;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.repository.ICarRepository;
import com.project.coches.domain.usecase.ICarUseCase;
import com.project.coches.persistance.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarService implements ICarUseCase {

    private final ICarRepository iCarRepository;
    @Override
    public List<CarDto> getAll() {
        return iCarRepository.getAll();
    }

    @Override
    public List<CarDto> getByIdBrandCar(Integer idBrandCar) {
        return iCarRepository.getByIdBrandCar(idBrandCar);
    }

    @Override
    public List<CarDto> findAllByPriceLessThanOrderByPriceDesc(Double price) {
        return iCarRepository.findAllByPriceLessThanOrderByPriceDesc(price);
    }

    @Override
    public Optional<CarDto> getCar(Integer idCar) {
        return iCarRepository.getCar(idCar);
    }

    @Override
    public CarDto save(CarDto newCar) {
        return iCarRepository.save(newCar);
    }

    public Optional<CarDto> update(CarDto updateCarDto){
        if(iCarRepository.getCar(updateCarDto.getCodeCar()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iCarRepository.save(updateCarDto));
    }

    @Override
    public boolean delete(Integer idCar) {
        if(iCarRepository.getCar(idCar).isEmpty()){
            return false;
        }
        iCarRepository.delete(idCar);
        return true;
    }
}
