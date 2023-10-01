package com.zerodha.backend.dao;

import com.zerodha.backend.persistence.entity.PlatformEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformDAO extends JpaRepository<PlatformEntity, Integer> {
}
