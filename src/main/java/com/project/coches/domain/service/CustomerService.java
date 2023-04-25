package com.project.coches.domain.service;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.domain.usecase.ICustomerUseCase;
import com.project.coches.exception.EmailValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerUseCase {

    private final ICustomerRepository iCustomerRepository;

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return iCustomerRepository.getCustomerByCardId(cardId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    @Override
    public ResponseCustomerDto save(CustomerDto newCustomer) {
        System.out.println(newCustomer);
        if(!newCustomer.getEmail().matches("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\n" +
                "                        + \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")){
            throw new EmailValidationException();
        }
        String passwordGenerated = this.generateRandomPassword(8);
        newCustomer.setPassword(passwordGenerated);
        newCustomer.setActive(1);
        iCustomerRepository.save(newCustomer);
        ResponseCustomerDto responseCustomerDto = new ResponseCustomerDto(passwordGenerated);
        return responseCustomerDto;
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto updateCustomerDto) {
        if(iCustomerRepository.getCustomerByCardId(updateCustomerDto.getCardId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(iCustomerRepository.save(updateCustomerDto));
    }

    @Override
    public boolean delete(String cardId) {
        if(iCustomerRepository.getCustomerByCardId(cardId).isEmpty()){
            return false;
        }
        iCustomerRepository.delete(cardId);
        return true;
    }

    private String generateRandomPassword(int len){
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom secureRandom = new SecureRandom();

        StringBuilder st = new StringBuilder();

        for(int i= 0; i< len; i++){
            int randomIndex = secureRandom.nextInt(chars.length());
            st.append(chars.charAt(randomIndex));
        }

        return st.toString();
    }
}
