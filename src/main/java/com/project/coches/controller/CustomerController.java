package com.project.coches.controller;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.usecase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final ICustomerUseCase iCustomerUseCase;

    /**
     * Devuelve lista de clientes
     * @return HttpCode OK con la lista de clientes
     */
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll(){
        return ResponseEntity.ok(iCustomerUseCase.getAll());
    }

    /**
     * Devuelve cliente dado su cardId
     * @param cardId cardId del cliente a buscar
     * @return HttpCode OK si lo encuentra, HttpCode Not found de lo contrario
     */
    @GetMapping(path = "/{cardId}")
    public ResponseEntity<CustomerDto> getCustomerByCardId(@PathVariable String cardId){
        return ResponseEntity.of(iCustomerUseCase.getCustomerByCardId(cardId));
    }

    /**
     * Devuelve cliente dado su mail
     * @param email cardId del cliente a buscar
     * @return HttpCode OK si lo encuentra, HttpCode Not found de lo contrario
     */
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email){
        Optional<CustomerDto> optCustomerDto = iCustomerUseCase.getCustomerByEmail(email);
        return ResponseEntity.of(optCustomerDto);
    }

    /**
     * Crea un nuevo cliente
     * @param customerDto cliente a crear
     * @return HttpCode CREATED si lo crea correctamente, HttpCode Bad Request de lo contrario
     */
    @PostMapping
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDto){
       // try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCustomerUseCase.save(customerDto));
        //} catch (Exception e){
         //   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseCustomerDto(e.getMessage())); //.build();
        //}
    }

    /**
     * Actualiza un cliente
     * @param customerDtoUpdate cliente actualizar
     * @return HttpCode OK si actualiza correctamente
     */
    @PutMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDtoUpdate){
        return ResponseEntity.of(iCustomerUseCase.update(customerDtoUpdate));
    }


    /**
     * Elimina un cliente dado su cardId
     * @param cardId cardId a eliminar cliente
     * @return HttpCode OK si se elimina correctamente de lo contraio NOT FOUND
     */
    @DeleteMapping(path = "/{cardId}")
    public ResponseEntity<Boolean> delete(@PathVariable String cardId){
        return new ResponseEntity<>(
                this.iCustomerUseCase.delete(cardId)? HttpStatus.OK: HttpStatus.NOT_FOUND
        );
    }
}
