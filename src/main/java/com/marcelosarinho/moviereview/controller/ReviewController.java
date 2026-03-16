package com.marcelosarinho.moviereview.controller;

import com.marcelosarinho.moviereview.entity.Review;
import com.marcelosarinho.moviereview.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {
    @Autowired
    private ReviewService service;

    @GetMapping
    public ResponseEntity<List<Review>> findAll() {
        List<Review> Reviews = service.findAll();
        return ResponseEntity.ok().body(Reviews);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Review>> findById(@PathVariable Long id) {
        Optional<Review> Review = service.findById(id);
        return ResponseEntity.ok().body(Review);
    }

    @PostMapping
    public ResponseEntity<Review> insert(@Valid @RequestBody Review obj) {
        obj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Review> update(@PathVariable Long id, @RequestBody Review obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
