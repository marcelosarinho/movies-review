package com.marcelosarinho.moviereview.service;

import com.marcelosarinho.moviereview.entity.Movie;
import com.marcelosarinho.moviereview.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public Optional<Movie> findById(Long id) {
        return repository.findById(id);
    }

    public Movie insert(Movie obj) {
        return repository.save(obj);
    }

    public Movie update(Long id, Movie obj) {
        Movie entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void updateData(Movie entity, Movie movie) {
        entity.setTitle(movie.getTitle());
        entity.setReleaseYear(movie.getReleaseYear());
    }
}
