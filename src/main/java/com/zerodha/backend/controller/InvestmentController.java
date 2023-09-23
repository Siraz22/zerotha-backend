package com.zerodha.backend.controller;

import com.zerodha.backend.persistence.entity.InvestmentEntity;
import com.zerodha.backend.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/investment")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @GetMapping("/{id}")
    public InvestmentEntity findOne(@PathVariable Integer id) {
        return investmentService.findOne(id);
    }

    @GetMapping
    public List<InvestmentEntity> findAll() {
        return investmentService.findAll();
    }
}