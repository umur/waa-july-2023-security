package com.miu.springsecurity.service.impl;

import com.miu.springsecurity.aspect.annotation.ExecutionTime;
import com.miu.springsecurity.dto.ReviewDto;
import com.miu.springsecurity.entity.Review;
import com.miu.springsecurity.repository.ReviewRepo;
import com.miu.springsecurity.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;
    private final ModelMapper modelMapper;
    @Override
    public void save(Review review) {
    reviewRepo.save(review);
    }

    @Override
    @ExecutionTime
    public List<ReviewDto> findAll() {

        var reviewList= (List<Review>)reviewRepo.findAll() ;
        return reviewList.stream().map(review -> modelMapper.map(review, ReviewDto.class)).toList();
    }

    @Override
    @ExecutionTime
    public ReviewDto findById(int id) {
        return modelMapper.map(reviewRepo.findById(id).get(), ReviewDto.class);
    }
    @Override
    @ExecutionTime
    public void deleteById(int id) {
    reviewRepo.deleteById(id);
    }

    @Override
    @ExecutionTime
    public List<ReviewDto> reviewsByProductId(int id) {

        return reviewRepo.findReviewByProduct_Id(id).stream().map(review ->
                modelMapper.map(review,ReviewDto.class)).toList();
    }

//    private ReviewDto getDto(Review review){
//        return modelMapper.map(review, ReviewDto.class);
//    }
//    private List<ReviewDto> getDto(List<Review> review){
//        return review.stream().map(p->{
//            return getDto(p);
//        }).collect(Collectors.toList());
//    }
}
