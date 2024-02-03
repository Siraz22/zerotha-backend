package com.zerodha.backend.service.impl;

import com.zerodha.backend.dao.BankDAO;
import com.zerodha.backend.persistence.entity.BankEntity;
import com.zerodha.backend.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankDAO bankDAO;

    @Override
    public BankEntity create(BankEntity bankEntity) {
        return bankDAO.save(bankEntity);
    }

    @Override
    public BankEntity findOne(Integer bankId) {
        Optional<BankEntity> optionalBank = bankDAO.findById(bankId);
        return optionalBank.orElse(null);
    }

    @Override
    public BankEntity update(Integer bankId, BankEntity updatedBank) {
        Optional<BankEntity> optionalBank = bankDAO.findById(bankId);
        if (optionalBank.isPresent()) {
            BankEntity bankEntity = optionalBank.get();
            bankEntity.setName(updatedBank.getName());
            return bankDAO.save(bankEntity);
        }
        return null;
    }

    @Override
    public void delete(Integer bankId) {
        bankDAO.deleteById(bankId);
    }

    @Override
    public List<BankEntity> findAll() {
        return bankDAO.findAll();
    }
}