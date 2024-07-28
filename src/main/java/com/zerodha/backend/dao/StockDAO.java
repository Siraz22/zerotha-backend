package com.zerodha.backend.dao;

import com.zerodha.backend.persistence.entity.StockEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StockDAO extends JpaRepository<StockEntity, Integer>, QuerydslPredicateExecutor<StockEntity>
{
}
