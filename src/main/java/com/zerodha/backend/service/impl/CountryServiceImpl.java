package com.zerodha.backend.service.impl;

import java.util.List;

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
        return null;
    }

    @Override
    public CountryEntity findOne(Integer countryId)
    {
        return null;
    }

    @Override
    public CountryEntity update(Integer countryId, CountryEntity countryEntity)
    {
        return null;
    }

    @Override
    public void delete(Integer countryId)
    {

    }

    @Override
    public List<CountryEntity> findAll()
    {
        return null;
    }
}
