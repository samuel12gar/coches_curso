package com.project.coches.domain.repository;

import com.project.coches.domain.dto.PurchaseBillResponseDto;
import com.project.coches.domain.dto.PurchaseRequestDto;
import com.project.coches.domain.dto.PurchaseResponseDto;

import java.util.List;

public interface IPurchaseRepository {

    List<PurchaseResponseDto> getAll();
    PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto);

    List<PurchaseResponseDto> getByIdCustomer(String cardId);

    PurchaseResponseDto getByNumberBill(Integer numberBill);

}
