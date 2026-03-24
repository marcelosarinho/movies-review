package com.marcelosarinho.moviereview.mapper;

import com.marcelosarinho.moviereview.dto.review.ReviewCreateDTO;
import com.marcelosarinho.moviereview.dto.review.ReviewDTO;
import com.marcelosarinho.moviereview.entity.Review;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDTO toReviewDTO(Review review);
    Review toReviewEntity(ReviewCreateDTO reviewCreateDTO);
    List<ReviewDTO> toReviewDTOlist(List<Review> reviews);
}
