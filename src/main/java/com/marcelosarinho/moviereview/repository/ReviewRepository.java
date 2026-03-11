package com.marcelosarinho.moviereview.repository;

import com.marcelosarinho.moviereview.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
