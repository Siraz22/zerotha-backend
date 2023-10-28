package com.zerodha.backend.dao;

import com.zerodha.backend.persistence.entity.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDAO extends JpaRepository<BankEntity, Integer> {
}
