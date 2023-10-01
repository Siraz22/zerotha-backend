package com.zerodha.backend.service;

import com.zerodha.backend.persistence.entity.UserEntity;

import java.util.List;

public interface UserService {
    //CRUD operations
    UserEntity create(UserEntity user);

    UserEntity findOne(Integer userId);

    UserEntity update(Integer userId, UserEntity updatedUser);

    void deleteUser(Integer userId);

    //Other operations
    List<UserEntity> findAll();
}
