package com.marcelosarinho.moviereview.controller;

import com.marcelosarinho.moviereview.entity.User;
import com.marcelosarinho.moviereview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users =  service.findAll();
        return ResponseEntity.ok().body(users);
    }
}
