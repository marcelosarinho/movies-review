package com.marcelosarinho.moviereview.dto.watchlist;

import com.marcelosarinho.moviereview.dto.movie.MovieDTO;
import com.marcelosarinho.moviereview.entity.enums.Interest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WatchlistDTO {
    private Long id;
    private MovieDTO movie;
    private Interest interest;
    private Instant createdAt;
    private Instant updatedAt;
}
