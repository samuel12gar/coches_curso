package com.project.coches.domain.service;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.domain.usecase.ICustomerUseCase;
import com.project.coches.exception.CustomerExistsException;
import com.project.coches.exception.CustomerNotExistException;
import com.project.coches.exception.EmailValidationException;
import com.project.coches.security.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerUseCase {

    private final ICustomerRepository iCustomerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        System.out.println(this.getClass()+" "+cardId);
        Optional<CustomerDto> optCustomer = iCustomerRepository.getCustomerByCardId(cardId);
        System.out.println(this.getClass()+" "+optCustomer.stream().findFirst());
        return optCustomer;
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    @Override
    public ResponseCustomerDto save(CustomerDto newCustomer) {
        System.out.println(newCustomer);
        //boolean matchEmail = newCustomer.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@\"\n" +
        //        "                + \"[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$");
        //System.out.println(matchEmail);
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(newCustomer.getEmail());
        boolean matchEmail = matcher.matches();
        if(!matchEmail){
            throw new EmailValidationException();
        }
        if(getCustomerByCardId(newCustomer.getCardId()).isPresent() || getCustomerByEmail(newCustomer.getEmail()).isPresent()){
            throw new CustomerExistsException();
        }
        String passwordGenerated = generateRandomPassword(10);
        //System.out.println(passwordEncoder.encode(passwordGenerated));
        newCustomer.setPassword(passwordEncoder.encode(passwordGenerated));
        newCustomer.setActive(1);
        newCustomer.setRol(Roles.CUSTOMER);
        System.out.println("Antes de guardar "+newCustomer);
        iCustomerRepository.save(newCustomer);
        ResponseCustomerDto responseCustomerDto = new ResponseCustomerDto(passwordGenerated);
        return responseCustomerDto;
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto updateCustomerDto) {
        if(iCustomerRepository.getCustomerByCardId(updateCustomerDto.getCardId()).isEmpty()){
            return Optional.empty();
        }
        updateCustomerDto.setActive(1);
        updateCustomerDto.setRol(Roles.CUSTOMER);
        //System.out.println(passwordEncoder.encode(passwordGenerated));
        updateCustomerDto.setPassword(passwordEncoder.encode(updateCustomerDto.getPassword()));

        System.out.println(this.getClass()+" "+updateCustomerDto);
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
