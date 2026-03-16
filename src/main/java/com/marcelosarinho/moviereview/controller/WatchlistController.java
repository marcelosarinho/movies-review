package com.marcelosarinho.moviereview.controller;

import com.marcelosarinho.moviereview.entity.Watchlist;
import com.marcelosarinho.moviereview.service.WatchlistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/watchlists")
public class WatchlistController {
    @Autowired
    private WatchlistService service;

    @PostMapping
    public ResponseEntity<Watchlist> insert(@Valid @RequestBody Watchlist obj) {
        obj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
