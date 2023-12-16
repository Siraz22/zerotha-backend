package com.zerodha.backend.dao;

import com.zerodha.backend.persistence.entity.StockEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockDAO extends JpaRepository<StockEntity, Integer>
{
}
