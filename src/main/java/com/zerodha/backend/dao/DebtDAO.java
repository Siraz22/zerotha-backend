package com.zerodha.backend.dao;

import com.zerodha.backend.persistence.entity.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtDAO extends JpaRepository<DebtEntity, Integer>
{
}
