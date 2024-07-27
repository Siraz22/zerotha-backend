package com.zerodha.backend.service;

import com.zerodha.backend.controller.params.StockSearchParams;
import com.zerodha.backend.dao.StockDAO;
import com.zerodha.backend.dto.StockDTO;
import com.zerodha.backend.dto.StockUpdateDTO;
import com.zerodha.backend.persistence.entity.StockEntity;

import java.util.List;

public interface StockService {
    // CRUD operations
    StockDTO create(StockDTO stockDTO);

    StockDTO findOne(Integer stockId);

    StockDTO update(StockUpdateDTO stockUpdateDTO);

    void delete(Integer stockId);

    // Other operations
    List<StockDTO> findAll(StockSearchParams stockSearchParams);
}
