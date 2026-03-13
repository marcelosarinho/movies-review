package com.marcelosarinho.moviereview.repository;

import com.marcelosarinho.moviereview.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUserId(Long id);
    List<Review> findByMovieId(Long id);
}
