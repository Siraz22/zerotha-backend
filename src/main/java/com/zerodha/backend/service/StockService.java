package com.zerodha.backend.service;

import com.zerodha.backend.dao.StockDAO;
import com.zerodha.backend.dto.StockDTO;
import com.zerodha.backend.persistence.entity.StockEntity;

import java.util.List;

public interface StockService {
    // CRUD operations
    StockDTO create(StockDTO stockDTO);

    StockDTO findOne(Integer stockId);

    StockDTO update(Integer stockId, StockDTO stockDTO);

    void delete(Integer stockId);

    // Other operations
    List<StockDTO> findAll();
}
