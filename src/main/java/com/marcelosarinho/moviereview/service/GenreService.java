package com.marcelosarinho.moviereview.service;

import com.marcelosarinho.moviereview.dto.genre.GenreDTO;
import com.marcelosarinho.moviereview.entity.Genre;
import com.marcelosarinho.moviereview.mapper.GenreMapper;
import com.marcelosarinho.moviereview.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository repository;

    @Autowired
    private GenreMapper mapper;

    public List<GenreDTO> findAll() {
        return mapper.toGenreDTOList(repository.findAll());
    }

    public GenreDTO findById(Long id) {
        Genre genre = repository.findById(id).orElseThrow(() -> new RuntimeException("Gênero não encontrado!"));
        return mapper.toGenreDTO(genre);
    }

    public GenreDTO insert(GenreDTO dto) {
        Genre entity = mapper.toGenreEntity(dto);
        entity = repository.save(entity);
        return mapper.toGenreDTO(entity);
    }

    public GenreDTO update(Long id, GenreDTO dto) {
        Genre entity = repository.getReferenceById(id);
        updateData(entity, dto);
        entity = repository.save(entity);
        return mapper.toGenreDTO(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void updateData(Genre entity, GenreDTO dto) {
        entity.setName(dto.getName());
    }
}
