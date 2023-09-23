package com.zerodha.backend.controller;

import com.zerodha.backend.persistence.entity.BankEntity;
import com.zerodha.backend.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping
    public BankEntity create(@RequestBody BankEntity bankEntity) {
        return bankService.create(bankEntity);
    }

    @GetMapping("/{id}")
    public BankEntity findOne(@PathVariable Integer id) {
        return bankService.findOne(id);
    }

    @PatchMapping("/{id}")
    public BankEntity update(@PathVariable Integer id, @RequestBody BankEntity updatedBank) {
        return bankService.update(id, updatedBank);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        bankService.delete(id);
    }

    @GetMapping
    public List<BankEntity> findAll() {
        return bankService.findAll();
    }
}
