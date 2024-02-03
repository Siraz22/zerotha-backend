package com.zerodha.backend.mapper;

import java.util.List;

import com.zerodha.backend.dto.StockDTO;
import com.zerodha.backend.dto.StockUpdateDTO;
import com.zerodha.backend.persistence.entity.StockEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface StockMapper
{
    StockEntity toEntity(StockDTO stockDTO);

    StockDTO toDTO(StockEntity stockEntity);

    List<StockDTO> toDTOs(List<StockEntity> stockEntities);


@Mapping(target = "symbol", ignore = true)
@Mapping(target = "platform", ignore = true)
@Mapping(target = "name", ignore = true)
@Mapping(target = "investmentHolder", ignore = true)
@Mapping(target = "associatedCountry", ignore = true)
@Mapping(target = "id", ignore = true)
void updateEntity(StockUpdateDTO updateDTO, @MappingTarget StockEntity stockEntity);
}
