package com.project.coches.controller;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.usecase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/cars")
public class CarController {

    private final ICarUseCase iCarUseCase;

    /**
     * Devuelve lista de coches
     * @return HttpCode OK con la lista de coches
     */
    @GetMapping
    public ResponseEntity<List<CarDto>> getAll(){
        return ResponseEntity.ok(iCarUseCase.getAll());
    }
    /**
     * Devuelve cliente dado su cardId
     * @param idBrandCar cardId del cliente a buscar
     * @return HttpCode OK si lo encuentra, HttpCode Not found de lo contrario
     */
    @GetMapping(path = "/brand-car/{idBrandCar}")
    public ResponseEntity<List<CarDto>> getByIdBrandCar(@PathVariable Integer idBrandCar){
        return ResponseEntity.ok(iCarUseCase.getByIdBrandCar(idBrandCar));
    }

    /**
     * Devuelve cliente dado su cardId
     * @param priceCar cardId del cliente a buscar
     * @return HttpCode OK si lo encuentra, HttpCode Not found de lo contrario
     */
    @GetMapping(path = "/price/{priceCar}")
    public ResponseEntity<List<CarDto>> findAllByPriceLessThanOrderByPriceDesc(@PathVariable Double priceCar){
        return ResponseEntity.ok(iCarUseCase.findAllByPriceLessThanOrderByPriceDesc(priceCar));
    }

    /**
     * Devuelve coche por id coche
     * @param idCar cardId del cliente a buscar
     * @return HttpCode OK si lo encuentra, HttpCode Not found de lo contrario
     */
    @GetMapping(path = "/{idCar}")
    public ResponseEntity<CarDto> getCar(@PathVariable Integer idCar){
        Optional<CarDto> optCarDto = iCarUseCase.getCar(idCar);
        return ResponseEntity.of(optCarDto);
    }

    /**
     * Crea un nuevo coche
     * @param carDto coche a crear
     * @return HttpCode CREATED si lo crea correctamente, HttpCode Bad Request de lo contrario
     */
    @PostMapping
    public ResponseEntity<CarDto> save(@RequestBody CarDto carDto){
        // try {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCarUseCase.save(carDto));
        //} catch (Exception e){
        //   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseCustomerDto(e.getMessage())); //.build();
        //}
    }

    /**
     * Actualiza un cliente
     * @param carDtoUpdate cliente actualizar
     * @return HttpCode OK si actualiza correctamente
     */
    @PutMapping
    public ResponseEntity<CarDto> update(@RequestBody CarDto carDtoUpdate){
        return ResponseEntity.of(iCarUseCase.update(carDtoUpdate));
    }

    @DeleteMapping(path = "/{cardId}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer cardId){
        return new ResponseEntity<>(
                this.iCarUseCase.delete(cardId)? HttpStatus.OK: HttpStatus.NOT_FOUND
        );
    }



}
