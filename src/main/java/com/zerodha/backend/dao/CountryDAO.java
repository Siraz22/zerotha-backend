package com.zerodha.backend.dao;

import com.zerodha.backend.persistence.entity.CountryEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDAO extends JpaRepository<CountryEntity, Integer>
{
}
