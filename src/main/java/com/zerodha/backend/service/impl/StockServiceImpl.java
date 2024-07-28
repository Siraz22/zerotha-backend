package com.zerodha.backend.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.zerodha.backend.controller.params.StockSearchParams;
import com.zerodha.backend.dao.StockDAO;
import com.zerodha.backend.dto.StockDTO;
import com.zerodha.backend.dto.StockUpdateDTO;
import com.zerodha.backend.enums.InvestmentType;
import com.zerodha.backend.mapper.CountryMapper;
import com.zerodha.backend.mapper.StockMapper;
import com.zerodha.backend.persistence.entity.BankEntity;
import com.zerodha.backend.persistence.entity.CountryEntity;
import com.zerodha.backend.persistence.entity.QStockEntity;
import com.zerodha.backend.persistence.entity.StockEntity;
import com.zerodha.backend.service.BankService;
import com.zerodha.backend.service.CountryService;
import com.zerodha.backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

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
    public List<StockDTO> findAll(StockSearchParams stockSearchParams) {
        BooleanBuilder where = buildFilter(stockSearchParams);

        List<StockEntity> stockEntities = (List<StockEntity>) stockDAO.findAll(where);
        return stockMapper.toDTOs(stockEntities);
    }

    private BooleanBuilder buildFilter(StockSearchParams stockSearchParams){
        BooleanBuilder where = new BooleanBuilder();

        if(nonNull(stockSearchParams.getCountryId())){
            where.and(QStockEntity.stockEntity.associatedCountry.id.eq(stockSearchParams.getCountryId()));
        }

        return where;
    }
}
