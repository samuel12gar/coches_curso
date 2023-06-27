package com.project.coches.domain.usecase;

import com.project.coches.domain.dto.PurchaseBillResponseDto;
import com.project.coches.domain.dto.PurchaseRequestDto;
import com.project.coches.domain.dto.PurchaseResponseDto;

import java.util.List;

public interface IPurchaseUseCase {

    PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto);

    List<PurchaseResponseDto> getAll();

    List<PurchaseResponseDto> getByIdCustomer(String cardId);

    PurchaseResponseDto getByNumberBill(Integer numberBill);
}
