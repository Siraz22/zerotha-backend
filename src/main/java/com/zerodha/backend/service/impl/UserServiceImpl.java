package com.zerodha.backend.service.impl;

import com.zerodha.backend.dao.UserDAO;
import com.zerodha.backend.persistence.entity.UserEntity;
import com.zerodha.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;


    @Override
    public UserEntity create(UserEntity user) {
        return userDAO.save(user);
    }

    @Override
    public UserEntity findOne(Integer userId) {
        return userDAO.findById(userId).orElseThrow(() -> new IllegalStateException("User with ID " + userId + " not found."));
    }

    @Override
    public UserEntity update(Integer userId, UserEntity updatedUser) {
        Optional<UserEntity> userOptional = userDAO.findById(userId);
        if (userOptional.isPresent()) {
            UserEntity userEntity = userOptional.get();
            userEntity.setUsername(updatedUser.getUsername());
            userEntity.setPassword(updatedUser.getPassword());
            userEntity.setEmailAddress(updatedUser.getEmailAddress());
            return userDAO.save(userEntity);
        }
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {
        Optional<UserEntity> userOptional = userDAO.findById(userId);
        if (userOptional.isPresent()) {
            UserEntity userEntity = userOptional.get();
            userDAO.delete(userEntity);
        }
    }

    @Override
    public List<UserEntity> findAll() {
        return userDAO.findAll();
    }
}
