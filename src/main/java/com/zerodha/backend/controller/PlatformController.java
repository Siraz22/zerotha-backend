package com.zerodha.backend.controller;

import com.zerodha.backend.persistence.entity.PlatformEntity;
import com.zerodha.backend.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/platform")
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    @PostMapping
    public PlatformEntity create(@RequestBody PlatformEntity platformEntity) {
        return platformService.create(platformEntity);
    }

    @GetMapping("/{id}")
    public PlatformEntity findOne(@PathVariable Integer id) {
        return platformService.findOne(id);
    }

    @PatchMapping("/{id}")
    public PlatformEntity update(@PathVariable Integer id, @RequestBody PlatformEntity updatedPlatform) {
        return platformService.update(id, updatedPlatform);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        platformService.delete(id);
    }

    @GetMapping
    public List<PlatformEntity> findAll() {
        return platformService.findAll();
    }
}
