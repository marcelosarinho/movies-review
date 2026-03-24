package com.marcelosarinho.moviereview.mapper;

import com.marcelosarinho.moviereview.dto.movie.MovieCreateDTO;
import com.marcelosarinho.moviereview.dto.movie.MovieDTO;
import com.marcelosarinho.moviereview.entity.Genre;
import com.marcelosarinho.moviereview.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDTO toMovieDTO(Movie movie);
    Movie toMovieEntity(MovieCreateDTO movieCreateDTO);
    List<MovieDTO> toMovieDTOList(List<Movie> movies);

    default List<String> map(Set<Genre> genres) {
        if (genres == null) return List.of();

        return genres.stream().map(Genre::getName).toList();
    }
}
