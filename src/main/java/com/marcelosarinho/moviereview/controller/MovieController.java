package com.marcelosarinho.moviereview.controller;

import com.marcelosarinho.moviereview.entity.Movie;
import com.marcelosarinho.moviereview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/movies")
public class MovieController {
    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        List<Movie> movies = service.findAll();
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>> findById(@PathVariable Long id) {
        Optional<Movie> movie = service.findById(id);
        return ResponseEntity.ok().body(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> insert(Movie obj) {
        Movie movie = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Movie> update(@PathVariable Long id, @RequestBody Movie obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
