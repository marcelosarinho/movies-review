package com.marcelosarinho.moviereview.repository;

import com.marcelosarinho.moviereview.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
