package com.zerodha.backend.service;

import com.zerodha.backend.persistence.entity.InvestmentEntity;

import java.util.List;

public interface InvestmentService {
    // CRUD operations - only allowing read operations for abstract
    InvestmentEntity findOne(Integer investmentId);

    // Other operations
    List<InvestmentEntity> findAll();
}