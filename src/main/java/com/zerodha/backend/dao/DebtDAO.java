package com.zerodha.backend.dao;

import com.zerodha.backend.persistence.entity.DebtEntity;
import com.zerodha.backend.persistence.entity.StockEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DebtDAO extends JpaRepository<DebtEntity, Integer>, QuerydslPredicateExecutor<DebtEntity>
{
}
