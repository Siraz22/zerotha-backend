package com.zerodha.backend.mapper;

import java.util.List;

import com.zerodha.backend.dto.CountryDTO;
import com.zerodha.backend.persistence.entity.CountryEntity;

import org.mapstruct.Mapper;

@Mapper
public interface CountryMapper
{
    CountryEntity toEntity(CountryDTO countryDTO);
    CountryDTO toDTO(CountryEntity countryEntity);
    List<CountryDTO> toDTOs(List<CountryEntity> countryEntities);
}
