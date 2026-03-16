package com.marcelosarinho.moviereview.dto.movie;

import com.marcelosarinho.moviereview.entity.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieCreateDTO {
    @NotBlank(message = "Título é obrigatório!")
    private String title;

    private Integer releaseYear;

    @NotEmpty(message = "Filme deve ter pelo menos um gênero")
    private Set<Long> genreIds;
}
