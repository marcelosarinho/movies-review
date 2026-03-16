package com.marcelosarinho.moviereview.dto;

import com.marcelosarinho.moviereview.entity.enums.Interest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WatchlistDTO {
    private Long id;
    private Long userId;
    private Long movieId;
    private Interest interest;
}
