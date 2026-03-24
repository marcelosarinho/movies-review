package com.marcelosarinho.moviereview.service;

import com.marcelosarinho.moviereview.dto.review.ReviewDTO;
import com.marcelosarinho.moviereview.entity.Review;
import com.marcelosarinho.moviereview.mapper.ReviewMapper;
import com.marcelosarinho.moviereview.repository.ReviewRepository;
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

    public List<Review> findAll() {
        return repository.findAll();
    }

    public Optional<Review> findById(Long id) {
        return repository.findById(id);
    }

    public List<ReviewDTO> findByUserId(Long id) {
        return mapper.toReviewDTOList(repository.findByUserId(id));
    }

    public List<Review> findByMovieId(Long id) {
        return repository.findByMovieId(id);
    }

    public Review insert(Review obj) {
        return repository.save(obj);
    }

    public Review update(Long id, Review obj) {
        Review entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void updateData(Review entity, Review review) {
        entity.setRating(review.getRating());
        entity.setComment(review.getComment());
    }
}
