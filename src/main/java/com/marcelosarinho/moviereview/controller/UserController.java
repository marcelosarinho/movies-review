package com.marcelosarinho.moviereview.controller;

import com.marcelosarinho.moviereview.entity.Review;
import com.marcelosarinho.moviereview.entity.User;
import com.marcelosarinho.moviereview.service.ReviewService;
import com.marcelosarinho.moviereview.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/users")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity<List<Review>> findReviews(@PathVariable Long id) {
        List<Review> reviews = reviewService.findByUserId(id);
        return ResponseEntity.ok().body(reviews);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id) {
        Optional<User> user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@Valid @RequestBody User obj) {
        obj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
