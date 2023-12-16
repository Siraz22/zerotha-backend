package com.zerodha.backend.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import com.zerodha.backend.dao.CountryDAO;
import com.zerodha.backend.dto.CountryDTO;
import com.zerodha.backend.mapper.CountryMapper;
import com.zerodha.backend.persistence.entity.CountryEntity;
import com.zerodha.backend.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountryServiceImpl implements CountryService
{
    @Autowired
    private CountryDAO countryDAO;

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public CountryDTO create(CountryDTO countryDTO)
    {
        CountryEntity countryEntity = countryMapper.toEntity(countryDTO);
        return countryMapper.toDTO(countryDAO.save(countryEntity));
    }

    @Override
    public CountryDTO findOne(Integer countryId)
    {
        Optional<CountryEntity> optionalCountryEntity = countryDAO.findById(countryId);
        return optionalCountryEntity.map(countryEntity -> countryMapper.toDTO(countryEntity)).orElse(null);
    }

    @Override
    public CountryEntity findOneEntity(Integer countryId){
        return countryDAO.findById(countryId).orElseThrow(()-> new NoSuchElementException("Not Country found with Id "+countryId));
    }

    @Override
    public CountryDTO update(Integer countryId, CountryDTO updatedCountryDTO)
    {
        Optional<CountryEntity> optionalCountryEntity = countryDAO.findById(countryId);
        if(optionalCountryEntity.isPresent()){
            CountryEntity countryEntity = optionalCountryEntity.get();
            countryEntity.setName(updatedCountryDTO.getName());
            countryEntity.setCurrency(updatedCountryDTO.getCurrency());
        }
        return null;
    }

    @Override
    public void delete(Integer countryId)
    {
        countryDAO.deleteById(countryId);
    }

    @Override
    public List<CountryDTO> findAll()
    {
        List<CountryEntity> countryEntities = countryDAO.findAll();
        return countryMapper.toDTOs(countryEntities);
    }
}
