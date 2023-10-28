package com.zerodha.backend.service.impl;

import com.zerodha.backend.persistence.entity.PlatformEntity;
import com.zerodha.backend.dao.PlatformDAO;
import com.zerodha.backend.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformServiceImpl implements PlatformService {

    private final PlatformDAO platformDAO;

    @Autowired
    public PlatformServiceImpl(PlatformDAO platformDAO) {
        this.platformDAO = platformDAO;
    }

    @Override
    @Transactional
    public PlatformEntity create(PlatformEntity platformEntity) {
        return platformDAO.save(platformEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public PlatformEntity findOne(Integer platformId) {
        Optional<PlatformEntity> optionalPlatform = platformDAO.findById(platformId);
        return optionalPlatform.orElse(null);
    }

    @Override
    @Transactional
    public PlatformEntity update(Integer platformId, PlatformEntity updatedPlatform) {
        Optional<PlatformEntity> optionalPlatform = platformDAO.findById(platformId);
        if (optionalPlatform.isPresent()) {
            PlatformEntity platformEntity = optionalPlatform.get();
            platformEntity.setName(updatedPlatform.getName());
            return platformDAO.save(platformEntity);
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Integer platformId) {
        platformDAO.deleteById(platformId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlatformEntity> findAll() {
        return platformDAO.findAll();
    }
}
