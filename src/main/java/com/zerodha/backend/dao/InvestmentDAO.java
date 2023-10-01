package com.zerodha.backend.dao;

import com.zerodha.backend.persistence.entity.InvestmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentDAO extends JpaRepository<InvestmentEntity, Integer> {
}
