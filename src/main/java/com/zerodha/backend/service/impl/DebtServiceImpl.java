package com.zerodha.backend.service.impl;

import java.util.List;
import java.util.Optional;

import com.zerodha.backend.dao.DebtDAO;
import com.zerodha.backend.persistence.entity.DebtEntity;
import com.zerodha.backend.service.DebtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebtServiceImpl implements DebtService {

    @Autowired
    private DebtDAO debtDAO;

    @Override
    public DebtEntity create(DebtEntity debtEntity)
    {
        return debtDAO.save(debtEntity);
    }

    @Override
    public DebtEntity findOne(Integer debtId)
    {
        Optional<DebtEntity> optionalDebt = debtDAO.findById(debtId);
        return optionalDebt.orElse(null);
    }

    @Override
    public DebtEntity update(Integer id, DebtEntity updatedDebt)
    {
        Optional<DebtEntity> optionalDebt = debtDAO.findById(id);
        if(optionalDebt.isPresent()){
            DebtEntity debtEntity = optionalDebt.get();
            debtEntity.setName(updatedDebt.getName());
            debtEntity.setAssuredInterest(updatedDebt.getAssuredInterest());
            debtEntity.setAveragePrice(updatedDebt.getAveragePrice());
            debtEntity.setQuantity(updatedDebt.getQuantity());
//            debtEntity.setAssociatedCountry();
//            debtEntity.setPlatform();
//            debtEntity.setInvestmentHolder();
            return debtDAO.save(debtEntity);
        }
        return null;
    }

    @Override
    public void delete(Integer id)
    {
        debtDAO.deleteById(id);
    }

    @Override
    public List<DebtEntity> findAll()
    {
        return debtDAO.findAll();
    }
}
