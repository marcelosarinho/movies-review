package com.marcelosarinho.moviereview.controller;

import com.marcelosarinho.moviereview.dto.review.ReviewCreateDTO;
import com.marcelosarinho.moviereview.dto.review.ReviewDTO;
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
    public ResponseEntity<List<ReviewDTO>> findAll() {
        List<ReviewDTO> Reviews = service.findAll();
        return ResponseEntity.ok().body(Reviews);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReviewDTO> findById(@PathVariable Long id) {
        ReviewDTO Review = service.findById(id);
        return ResponseEntity.ok().body(Review);
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> insert(@Valid @RequestBody ReviewCreateDTO obj) {
        ReviewDTO review = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ReviewDTO> update(@PathVariable Long id, @RequestBody ReviewCreateDTO obj) {
        ReviewDTO review = service.update(id, obj);
        return ResponseEntity.ok().body(review);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
