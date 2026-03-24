package com.marcelosarinho.moviereview.mapper;

import com.marcelosarinho.moviereview.dto.review.ReviewCreateDTO;
import com.marcelosarinho.moviereview.dto.review.ReviewDTO;
import com.marcelosarinho.moviereview.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    @Mapping(source = "user.name", target = "username")
    @Mapping(source = "movie.id", target = "movieId")
    ReviewDTO toReviewDTO(Review review);
    Review toReviewEntity(ReviewCreateDTO reviewCreateDTO);
    List<ReviewDTO> toReviewDTOList(List<Review> reviews);
}
