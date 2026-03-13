package com.marcelosarinho.moviereview.service;

import com.marcelosarinho.moviereview.entity.Watchlist;
import com.marcelosarinho.moviereview.repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService {
    @Autowired
    private WatchlistRepository repository;

    public List<Watchlist> findByUserId(Long id) {
        return repository.findByUserId(id);
    }

    public Watchlist insert(Watchlist obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
