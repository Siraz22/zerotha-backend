package com.zerodha.backend.service;

import java.util.List;

import com.zerodha.backend.persistence.entity.DebtEntity;

public interface DebtService
{
    //CRUD operations
    DebtEntity create(DebtEntity debtEntity);

    DebtEntity findOne(Integer id);

    DebtEntity update(Integer id, DebtEntity updatedDebt);

    void delete(Integer id);

    List<DebtEntity> findAll();

    //other operations
}
