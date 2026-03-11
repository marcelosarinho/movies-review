package com.marcelosarinho.moviereview.service;

import com.marcelosarinho.moviereview.entity.User;
import com.marcelosarinho.moviereview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll() {
        return repository.findAll();
    }
}
