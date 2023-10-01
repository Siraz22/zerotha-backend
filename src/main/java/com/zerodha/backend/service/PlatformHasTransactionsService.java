package com.zerodha.backend.service;

import com.zerodha.backend.persistence.entity.PlatformHasTransactionsEntity;

import java.util.List;

public interface PlatformHasTransactionsService {
    // CRUD operations
    PlatformHasTransactionsEntity create(PlatformHasTransactionsEntity transactionEntity);

    PlatformHasTransactionsEntity findOne(Integer transactionId);

    PlatformHasTransactionsEntity update(Integer transactionId, PlatformHasTransactionsEntity updatedTransaction);

    void delete(Integer transactionId);

    // Other operations
    List<PlatformHasTransactionsEntity> findAll();
}