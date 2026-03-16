package com.marcelosarinho.moviereview.dto.genre;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreDTO {
    private Long id;

    @NotBlank(message = "Nome do gênero é obrigatório!")
    private String name;
}
