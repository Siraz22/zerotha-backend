package com.zerodha.backend.service.impl;

import java.util.List;
import java.util.Optional;

import com.zerodha.backend.dao.CountryDAO;
import com.zerodha.backend.persistence.entity.CountryEntity;
import com.zerodha.backend.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService
{
    @Autowired
    private CountryDAO countryDAO;

    @Override
    public CountryEntity create(CountryEntity countryEntity)
    {
        return countryDAO.save(countryEntity);
    }

    @Override
    public CountryEntity findOne(Integer countryId)
    {
        Optional<CountryEntity> optionalCountryEntity = countryDAO.findById(countryId);
        return optionalCountryEntity.orElse(null);
    }

    @Override
    public CountryEntity update(Integer countryId, CountryEntity updatedCountryEntity)
    {
        Optional<CountryEntity> optionalCountryEntity = countryDAO.findById(countryId);
        if(optionalCountryEntity.isPresent()){
            CountryEntity countryEntity = optionalCountryEntity.get();
            countryEntity.setName(updatedCountryEntity.getName());
            countryEntity.setCurrency(updatedCountryEntity.getCurrency());
        }
        return null;
    }

    @Override
    public void delete(Integer countryId)
    {
        countryDAO.deleteById(countryId);
    }

    @Override
    public List<CountryEntity> findAll()
    {
        return countryDAO.findAll();
    }
}
