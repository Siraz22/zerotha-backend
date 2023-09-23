package com.zerodha.backend.service;

import com.zerodha.backend.persistence.entity.PlatformEntity;

import java.util.List;

public interface PlatformService {
    // CRUD operations
    PlatformEntity create(PlatformEntity platformEntity);

    PlatformEntity findOne(Integer platformId);

    PlatformEntity update(Integer platformId, PlatformEntity updatedPlatform);

    void delete(Integer platformId);

    // Other operations
    List<PlatformEntity> findAll();
}
