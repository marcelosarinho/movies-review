package com.marcelosarinho.moviereview.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieSummaryDTO {
    private Long id;
    private String name;
    private List<String> genres;
}
