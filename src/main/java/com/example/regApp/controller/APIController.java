/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.regApp.controller;

import com.example.regApp.model.UserDetails;
import com.example.regApp.repo.UserRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Arosha
 */
@RestController
public class APIController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public ResponseEntity<?> getResponse() {
        return new ResponseEntity<>("Welcome", HttpStatus.OK);
    }

    @GetMapping(value = "/userInfo")
    public List<UserDetails> getUsers() {
        return userRepo.findAll();
    }

    //get user by id
    @GetMapping("/userInfo/{id}")
    public UserDetails getUserById(@PathVariable(value = "id") long userId) {
        return this.userRepo.findById(userId)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException(userId + "", this, "No record"));
    }
}
