package com.marcelosarinho.moviereview.mapper;

import com.marcelosarinho.moviereview.dto.genre.GenreDTO;
import com.marcelosarinho.moviereview.entity.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDTO toGenreDTO(Genre genre);
    Genre toGenreEntity(GenreDTO genreDTO);
    List<GenreDTO> toGenreDTOList(List<Genre> genres);
}
