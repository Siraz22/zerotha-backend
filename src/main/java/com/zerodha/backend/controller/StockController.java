package com.zerodha.backend.controller;

import com.zerodha.backend.dto.StockDTO;
import com.zerodha.backend.dto.StockUpdateDTO;
import com.zerodha.backend.persistence.constants.GlobalConstants;
import com.zerodha.backend.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(GlobalConstants.API_VERSION + "/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public StockDTO create(@RequestBody StockDTO stockDTO) {
        return stockService.create(stockDTO);
    }

    @GetMapping("/{id}")
    public StockDTO findOne(@PathVariable Integer id) {
        return stockService.findOne(id);
    }

    @PatchMapping()
    public StockDTO update(@RequestBody StockUpdateDTO stockUpdateDTO) {
        return stockService.update(stockUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        stockService.delete(id);
    }

    @GetMapping
    public List<StockDTO> findAll() {
        return stockService.findAll();
    }
}
