package com.marcelosarinho.moviereview.service;

import com.marcelosarinho.moviereview.dto.review.ReviewCreateDTO;
import com.marcelosarinho.moviereview.dto.review.ReviewDTO;
import com.marcelosarinho.moviereview.entity.Review;
import com.marcelosarinho.moviereview.mapper.ReviewMapper;
import com.marcelosarinho.moviereview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    @Autowired
    private ReviewMapper mapper;

    public List<ReviewDTO> findAll() {
        return mapper.toReviewDTOList(repository.findAll());
    }

    public ReviewDTO findById(Long id) {
        Review review = repository.findById(id).orElseThrow(() -> new RuntimeException("Crítica não encontrada!"));
        return mapper.toReviewDTO(review);
    }

    public List<ReviewDTO> findByUserId(Long id) {
        return mapper.toReviewDTOList(repository.findByUserId(id));
    }

    public List<ReviewDTO> findByMovieId(Long id) {
        return mapper.toReviewDTOList(repository.findByMovieId(id));
    }

    public ReviewDTO insert(ReviewCreateDTO obj) {
        Review entity = mapper.toReviewEntity(obj);
        return mapper.toReviewDTO(repository.save(entity));
    }

    public ReviewDTO update(Long id, ReviewCreateDTO obj) {
        Review entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return mapper.toReviewDTO(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void updateData(Review entity, ReviewCreateDTO review) {
        entity.setRating(review.getRating());
        entity.setComment(review.getComment());
    }
}
