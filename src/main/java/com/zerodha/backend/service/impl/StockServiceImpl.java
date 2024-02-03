package com.zerodha.backend.service.impl;

import com.zerodha.backend.dao.StockDAO;
import com.zerodha.backend.dto.StockDTO;
import com.zerodha.backend.dto.StockUpdateDTO;
import com.zerodha.backend.enums.InvestmentType;
import com.zerodha.backend.mapper.CountryMapper;
import com.zerodha.backend.mapper.StockMapper;
import com.zerodha.backend.persistence.entity.BankEntity;
import com.zerodha.backend.persistence.entity.CountryEntity;
import com.zerodha.backend.persistence.entity.StockEntity;
import com.zerodha.backend.service.BankService;
import com.zerodha.backend.service.CountryService;
import com.zerodha.backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDAO stockDAO;

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private CountryService countryService;

    @Autowired
    private BankService bankService;

    @Override
    public StockDTO create(StockDTO stockDTO) {

        BankEntity addedBank = bankService.create(new BankEntity());

        StockEntity stockEntity = stockMapper.toEntity(stockDTO);
        CountryEntity countryEntity = countryService.findOneEntity(stockDTO.getAssociatedCountryId());
        stockEntity.setAssociatedCountry(countryEntity);
        return stockMapper.toDTO(stockDAO.save(stockEntity));
    }

    @Override
    public StockDTO findOne(Integer stockId) {
        Optional<StockEntity> optionalStockEntity = stockDAO.findById(stockId);
        return optionalStockEntity.map(stockEntity -> stockMapper.toDTO(stockEntity)).orElse(null);
    }

    @Override
    public StockDTO update(StockUpdateDTO updatedStockDTO) {
        Optional<StockEntity> optionalStockEntity = stockDAO.findById(updatedStockDTO.getId());
        if (optionalStockEntity.isPresent()) {
            StockEntity stockEntity = optionalStockEntity.get();
            stockMapper.updateEntity(updatedStockDTO, stockEntity);
            return stockMapper.toDTO(stockDAO.save(stockEntity));
        }
        return null;
    }

    @Override
    public void delete(Integer stockId) {
        stockDAO.deleteById(stockId);
    }

    @Override
    public List<StockDTO> findAll() {
        List<StockEntity> stockEntities = stockDAO.findAll();
        return stockMapper.toDTOs(stockEntities);
    }
}
