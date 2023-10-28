package com.zerodha.backend.service.impl;

import com.zerodha.backend.dao.InvestmentDAO;
import com.zerodha.backend.persistence.entity.InvestmentEntity;
import com.zerodha.backend.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    @Autowired
    private InvestmentDAO investmentDAO;

    @Override
    @Transactional(readOnly = true)
    public InvestmentEntity findOne(Integer investmentId) {
        return investmentDAO.findById(investmentId)
                .orElseThrow(() -> new IllegalStateException("Investment with ID " + investmentId + " not found."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<InvestmentEntity> findAll() {
        return investmentDAO.findAll();
    }
}
