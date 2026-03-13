package com.marcelosarinho.moviereview.service;

import com.marcelosarinho.moviereview.entity.Genre;
import com.marcelosarinho.moviereview.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository repository;

    public List<Genre> findAll() {
        return repository.findAll();
    }

    public Optional<Genre> findById(Long id) {
        return repository.findById(id);
    }

    public Genre insert(Genre obj) {
        return repository.save(obj);
    }

    public Genre update(Long id, Genre obj) {
        Genre entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void updateData(Genre entity, Genre genre) {
        entity.setName(genre.getName());
    }
}
