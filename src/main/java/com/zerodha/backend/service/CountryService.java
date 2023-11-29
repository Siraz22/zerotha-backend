package com.zerodha.backend.service;

import java.util.List;

import com.zerodha.backend.dto.CountryDTO;
import com.zerodha.backend.persistence.entity.CountryEntity;

public interface CountryService {
    //CRUD operations
    CountryDTO create(CountryDTO countryDTO);

    CountryDTO findOne(Integer countryId);

    CountryDTO update(Integer countryId, CountryDTO countryDTO);

    void delete(Integer countryId);

    //Other operations
    List<CountryDTO> findAll();
}
