package com.zerodha.backend.controller;

import com.zerodha.backend.persistence.entity.PlatformHasTransactionsEntity;
import com.zerodha.backend.service.PlatformHasTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/platform-transaction")
public class PlatformHasTransactionController {
    @Autowired
    private PlatformHasTransactionsService platformHasTransactionService;

    @PostMapping
    public PlatformHasTransactionsEntity create(@RequestBody PlatformHasTransactionsEntity transactionEntity) {
        return platformHasTransactionService.create(transactionEntity);
    }

    @GetMapping("/{id}")
    public PlatformHasTransactionsEntity findOne(@PathVariable Integer id) {
        return platformHasTransactionService.findOne(id);
    }

    @PatchMapping("/{id}")
    public PlatformHasTransactionsEntity update(@PathVariable Integer id, @RequestBody PlatformHasTransactionsEntity updatedTransaction) {
        return platformHasTransactionService.update(id, updatedTransaction);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        platformHasTransactionService.delete(id);
    }

    @GetMapping
    public List<PlatformHasTransactionsEntity> findAll() {
        return platformHasTransactionService.findAll();
    }
}
