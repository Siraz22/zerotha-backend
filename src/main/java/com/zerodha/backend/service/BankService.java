package com.zerodha.backend.service;

import com.zerodha.backend.persistence.entity.BankEntity;

import java.util.List;

public interface BankService {
    // CRUD operations
    BankEntity create(BankEntity bankEntity);

    BankEntity findOne(Integer bankId);

    BankEntity update(Integer bankId, BankEntity updatedBank);

    void delete(Integer bankId);

    // Other operations
    List<BankEntity> findAll();
}
