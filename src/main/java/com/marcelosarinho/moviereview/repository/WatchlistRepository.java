package com.marcelosarinho.moviereview.repository;

import com.marcelosarinho.moviereview.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
}
