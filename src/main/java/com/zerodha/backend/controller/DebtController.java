package com.zerodha.backend.controller;

import java.util.List;

import com.zerodha.backend.persistence.constants.GlobalConstants;
import com.zerodha.backend.persistence.entity.DebtEntity;
import com.zerodha.backend.service.DebtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@RestController
@RequestMapping(GlobalConstants.API_VERSION+"/debt")
public class DebtController
{
    @Autowired
    private DebtService debtService;

    @PostMapping
    public DebtEntity create(@RequestBody DebtEntity debtEntity){
        return debtService.create(debtEntity);
    }

    @GetMapping("/{id}")
    public DebtEntity findOne(@PathVariable Integer id){
        return debtService.findOne(id);
    }

    @PatchMapping("/{id}")
    public DebtEntity update(@PathVariable Integer id, @RequestBody DebtEntity debtEntity){
        return debtService.update(id, debtEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        debtService.delete(id);
    }

    @GetMapping
    public List<DebtEntity> findAll(){
        return debtService.findAll();
    }

}
