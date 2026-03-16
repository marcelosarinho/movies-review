package com.marcelosarinho.moviereview.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long id;

    @Min(value = 1, message = "A avaliação mínima é 1!")
    @Max(value = 5, message = "A avaliação máxima é 5!")
    private Integer rating;

    private String comment;
}
