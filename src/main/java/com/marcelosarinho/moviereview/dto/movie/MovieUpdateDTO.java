package com.marcelosarinho.moviereview.dto.movie;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieUpdateDTO {
    @NotBlank(message = "Título é obrigatório!")
    private String title;

    private Integer releaseYear;
    private Set<Long> genreIds;
}
