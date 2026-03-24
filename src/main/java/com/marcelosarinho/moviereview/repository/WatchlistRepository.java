package com.marcelosarinho.moviereview.repository;

import com.marcelosarinho.moviereview.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
    @Query("""
        SELECT w FROM Watchlist w
        WHERE w.user.id = :id
        ORDER BY w.createdAt DESC
    """)
    List<Watchlist> findByUserId(Long id);
}
