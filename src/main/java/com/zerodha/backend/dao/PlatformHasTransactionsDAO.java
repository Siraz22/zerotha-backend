package com.zerodha.backend.dao;

import com.zerodha.backend.persistence.entity.PlatformHasTransactionsEntity;
import com.zerodha.backend.persistence.entity.StockEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PlatformHasTransactionsDAO extends JpaRepository<PlatformHasTransactionsEntity, Integer>, QuerydslPredicateExecutor<PlatformHasTransactionsEntity>
{
}
