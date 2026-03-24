package com.marcelosarinho.moviereview.controller;

import com.marcelosarinho.moviereview.dto.review.ReviewDTO;
import com.marcelosarinho.moviereview.dto.user.UserCreateDTO;
import com.marcelosarinho.moviereview.dto.user.UserDTO;
import com.marcelosarinho.moviereview.entity.Review;
import com.marcelosarinho.moviereview.entity.Watchlist;
import com.marcelosarinho.moviereview.service.ReviewService;
import com.marcelosarinho.moviereview.service.UserService;
import com.marcelosarinho.moviereview.service.WatchlistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private WatchlistService watchlistService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity<List<ReviewDTO>> findReviews(@PathVariable Long id) {
        List<ReviewDTO> reviews = reviewService.findByUserId(id);
        return ResponseEntity.ok().body(reviews);
    }

    @GetMapping(value = "/{id}/watchlists")
    public ResponseEntity<List<Watchlist>> findWatchlists(@PathVariable Long id) {
        List<Watchlist> watchlists = watchlistService.findByUserId(id);
        return ResponseEntity.ok().body(watchlists);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserCreateDTO obj) {
        UserDTO user = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserCreateDTO obj) {
        UserDTO user = service.update(id, obj);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
