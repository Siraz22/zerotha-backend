package com.zerodha.backend.service.impl;

import com.zerodha.backend.dao.PlatformHasTransactionsDAO;
import com.zerodha.backend.persistence.entity.PlatformHasTransactionsEntity;
import com.zerodha.backend.service.PlatformHasTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformHasTransactionsServiceImpl implements PlatformHasTransactionsService {

    @Autowired
    private PlatformHasTransactionsDAO PlatformHasTransactionsDAO;

    @Override
    public PlatformHasTransactionsEntity create(PlatformHasTransactionsEntity transactionEntity) {
        return PlatformHasTransactionsDAO.save(transactionEntity);
    }

    @Override
    public PlatformHasTransactionsEntity findOne(Integer transactionId) {
        Optional<PlatformHasTransactionsEntity> optionalTransaction = PlatformHasTransactionsDAO.findById(transactionId);
        return optionalTransaction.orElse(null);
    }

    @Override
    public PlatformHasTransactionsEntity update(Integer transactionId, PlatformHasTransactionsEntity updatedTransaction) {
        Optional<PlatformHasTransactionsEntity> optionalTransaction = PlatformHasTransactionsDAO.findById(transactionId);
        if (optionalTransaction.isPresent()) {
            PlatformHasTransactionsEntity transactionEntity = optionalTransaction.get();
            transactionEntity.setAmount(updatedTransaction.getAmount());
            transactionEntity.setBankEntity(updatedTransaction.getBankEntity());
            transactionEntity.setPlatformTransactionType(updatedTransaction.getPlatformTransactionType());
            transactionEntity.setPlatform(updatedTransaction.getPlatform());
            return PlatformHasTransactionsDAO.save(transactionEntity);
        }
        return null;
    }

    @Override
    public void delete(Integer transactionId) {
        PlatformHasTransactionsDAO.deleteById(transactionId);
    }

    @Override
    public List<PlatformHasTransactionsEntity> findAll() {
        return PlatformHasTransactionsDAO.findAll();
    }
}
