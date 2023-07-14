package cs545.springData.service.impl;

import cs545.springData.service.ReviewService;
import cs545.springData.entity.Review;
import cs545.springData.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
 private final ReviewRepo reviewRepo;
 @Override
 public List<Review> getReview(){
  return reviewRepo.findAll();
 }
 public String addReview(Review review ){
   reviewRepo.save(review);
  return "review added";
 }
 @Override
 public Review updateReview (Long id,Review  review){
  Optional<Review> rev = reviewRepo.findById(id);
  if(rev.isPresent()){

   rev.get().setComment(review.getComment());
   rev.get().setUser(review.getUser());
   rev.get().setProduct(review.getProduct());


   reviewRepo.save(rev.get());
  }
  return rev.get();

 }
 @Override
 public Review getById(Long id){
  Optional<Review> review= reviewRepo.findById(id);
  if(review.isPresent()) {
   return review.get();
  }else
   return null;
 }

 @Override
 public String DeleteById(Long id){
  Optional<Review> review= reviewRepo.findById(id);
  if(review.isPresent()){
   reviewRepo.deleteById(id);
  }
  return"Review deleted";
 }
 public List<Review> findByProductId(Long productId){
  return reviewRepo.findByProductId(productId);
 }
// @Override
// public List<Review> getReviewByProductId(Long productId){
//  return reviewRepo.getReviewByProductId(productId);
// }
}
