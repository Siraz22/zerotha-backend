package com.zerodha.backend.controller;

import com.zerodha.backend.persistence.entity.UserEntity;
import com.zerodha.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final String userPath = "api/v1/user";

    @Autowired
    private UserService userService;

    @PostMapping(path = userPath)
    UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.create(userEntity);
    }

    @GetMapping(path = userPath + "/{id}")
    UserEntity findOne(@PathVariable Integer id) {
        return userService.findOne(id);
    }

    @PatchMapping(path = userPath + "/{id}")
    UserEntity update(@PathVariable Integer id, @RequestBody UserEntity user) {
        return userService.update(id, user);
    }

    @DeleteMapping(path = userPath + "/{id}")
    void delete(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping(path = userPath)
    List<UserEntity> findAll() {
        return userService.findAll();
    }
}
