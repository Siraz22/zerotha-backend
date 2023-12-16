package com.zerodha.backend.mapper;

import java.util.List;

import com.zerodha.backend.dto.StockDTO;
import com.zerodha.backend.persistence.entity.StockEntity;

import org.mapstruct.Mapper;

@Mapper
public interface StockMapper
{
    StockEntity toEntity(StockDTO stockDTO);

    StockDTO toDTO(StockEntity stockEntity);

    List<StockDTO> toDTOs(List<StockEntity> stockEntities);
}
