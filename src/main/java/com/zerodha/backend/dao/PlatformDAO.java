package com.zerodha.backend.dao;

import com.zerodha.backend.persistence.entity.PlatformEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PlatformDAO extends JpaRepository<PlatformEntity, Integer>, QuerydslPredicateExecutor<PlatformEntity>
{
}
