package com.zerodha.backend.dao;

import com.zerodha.backend.persistence.entity.CountryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CountryDAO extends JpaRepository<CountryEntity, Integer>, QuerydslPredicateExecutor<CountryEntity>
{
}
