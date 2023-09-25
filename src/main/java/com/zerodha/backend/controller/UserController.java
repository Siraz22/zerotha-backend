package com.zerodha.backend.controller;

import com.zerodha.backend.persistence.constants.GlobalConstants;
import com.zerodha.backend.persistence.entity.UserEntity;
import com.zerodha.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(GlobalConstants.API_VERSION+"/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.create(userEntity);
    }

    @GetMapping("/{id}")
    UserEntity findOne(@PathVariable Integer id) {
        return userService.findOne(id);
    }

    @PatchMapping("/{id}")
    UserEntity update(@PathVariable Integer id, @RequestBody UserEntity user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping
    List<UserEntity> findAll() {
        return userService.findAll();
    }
}
