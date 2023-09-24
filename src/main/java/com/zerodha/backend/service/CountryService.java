package com.zerodha.backend.service;

import java.util.List;

import com.zerodha.backend.persistence.entity.CountryEntity;

public interface CountryService {
    //CRUD operations
    CountryEntity create(CountryEntity countryEntity);

    CountryEntity findOne(Integer countryId);

    CountryEntity update(Integer countryId, CountryEntity countryEntity);

    void delete(Integer countryId);

    //Other operations
    List<CountryEntity> findAll();
}
