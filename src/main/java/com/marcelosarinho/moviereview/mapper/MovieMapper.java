package com.marcelosarinho.moviereview.mapper;

import com.marcelosarinho.moviereview.dto.movie.MovieCreateDTO;
import com.marcelosarinho.moviereview.dto.movie.MovieDTO;
import com.marcelosarinho.moviereview.entity.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieDTO toMovieDTO(Movie movie);
    Movie toMovieEntity(MovieCreateDTO movieCreateDTO);
    List<MovieDTO> toMovieDTOList(List<Movie> movies);
}
