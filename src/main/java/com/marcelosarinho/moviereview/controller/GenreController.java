package com.marcelosarinho.moviereview.controller;

import com.marcelosarinho.moviereview.entity.Genre;
import com.marcelosarinho.moviereview.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {
    @Autowired
    private GenreService service;

    @GetMapping
    public ResponseEntity<List<Genre>> findAll() {
        List<Genre> genres = service.findAll();
        return ResponseEntity.ok().body(genres);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Genre>> findById(@PathVariable Long id) {
        Optional<Genre> genre = service.findById(id);
        return ResponseEntity.ok().body(genre);
    }

    @PostMapping
    public ResponseEntity<Genre> insert(@Valid @RequestBody Genre obj) {
        obj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Genre> update(@PathVariable Long id, @RequestBody Genre obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
