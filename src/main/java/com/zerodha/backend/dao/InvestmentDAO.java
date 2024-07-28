package com.zerodha.backend.dao;

import com.zerodha.backend.persistence.entity.InvestmentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface InvestmentDAO extends JpaRepository<InvestmentEntity, Integer>, QuerydslPredicateExecutor<InvestmentEntity>
{
}
