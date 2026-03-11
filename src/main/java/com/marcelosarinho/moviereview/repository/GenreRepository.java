package com.marcelosarinho.moviereview.repository;

import com.marcelosarinho.moviereview.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
