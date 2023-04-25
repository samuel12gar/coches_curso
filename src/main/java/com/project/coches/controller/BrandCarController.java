package com.project.coches.controller;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.usecase.IBrandCarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  Controlador rest de marca coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/brands-car")
public class BrandCarController {

    /**
     * servicio de marca coche
     */
    private final IBrandCarUseCase iBrandCarUseCase;

    /**
     * Devuelve lista de marca coches
     * @return HttpCode OK con la lista de marca coches
     */
    @GetMapping
    public ResponseEntity<List<BrandCarDto>> getAll(){
        return ResponseEntity.ok(iBrandCarUseCase.getAll());
        //return ResponseEntity.status(HttpStatus.OK)
         //       .body(iBrandCarService.getAll());
        //return new ResponseEntity<>(iBrandCarService.getAll(), HttpStatus.OK);
    }

    /**
     * Devuelve marca coche dado su id
     * @param id Id de la marca coche a buscar
     * @return HttpCode OK si la encuentra, HttpCode Not found de lo contrario
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarDto> getBrandCar(@PathVariable Integer id){
        return ResponseEntity.of(iBrandCarUseCase.getBrandCar(id));
    }

    /**
     * Crea una nueva marca coche
     * @param brandCarDto Marca coche a crear
     * @return HttpCode CREATED si la crea correctamente, HttpCode Bad Requeste de lo contrario
     */
    @PostMapping
    public ResponseEntity<BrandCarDto> save(@RequestBody BrandCarDto brandCarDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarUseCase.save(brandCarDto));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Actualiza una marca coche
     * @param brandCarDtoUpdate Marca coche actualizada
     * @return HttpCode OK si actualiza correctamente
     */
    @PutMapping
    public ResponseEntity<BrandCarDto> update(@RequestBody BrandCarDto brandCarDtoUpdate){
        return ResponseEntity.of(iBrandCarUseCase.update(brandCarDtoUpdate));
        /*if(iBrandCarService.update(brandCarPojoUpdate)==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(brandCarPojoUpdate);
        }*/
    }

    /**
     * Elimina una marca coche dado su Id
     * @param id Id de la marca coche a eliminar
     * @return HttpCode OK si se elimina correctamente de lo contraio NOT FOUND
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(
                this.iBrandCarUseCase.delete(id)? HttpStatus.OK: HttpStatus.NOT_FOUND
        );
    }
}
