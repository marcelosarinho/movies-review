package com.marcelosarinho.moviereview.dto.review;

import com.marcelosarinho.moviereview.dto.movie.MovieDTO;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long id;
    private Integer rating;
    private String comment;
    private String username;
    private MovieDTO movie;
    private Instant updatedAt;
}
