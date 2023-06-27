package com.project.coches.controller;

import com.project.coches.domain.dto.AuthCustomerDto;
import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.JwtResponseDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.usecase.IAuthUseCase;
import com.project.coches.domain.usecase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    private final IAuthUseCase iAuthUseCase;
    private final ICustomerUseCase iCustomerUseCase;


    @GetMapping()
    public ResponseEntity<JwtResponseDto> prueba() {
        return ResponseEntity.ok(new JwtResponseDto("prueba"));
    }

    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponseDto> signIn(@RequestBody AuthCustomerDto authCustomerDto) {
        return ResponseEntity.ok(iAuthUseCase.signIn(authCustomerDto));
    }

    @PostMapping(path = "/sign-out")
    public ResponseEntity<JwtResponseDto> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        return ResponseEntity.ok(iAuthUseCase.signOut(jwt));
    }

    /**
     * Crea un nuevo cliente
     * @param customerDto cliente a crear
     * @return HttpCode CREATED si lo crea correctamente, HttpCode Bad Request de lo contrario
     */
    @PostMapping(path = "/register")
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDto){
        // try {
        System.out.println("/register:"+customerDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCustomerUseCase.save(customerDto));
        //} catch (Exception e){
        //   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseCustomerDto(e.getMessage())); //.build();
        //}
    }
}
