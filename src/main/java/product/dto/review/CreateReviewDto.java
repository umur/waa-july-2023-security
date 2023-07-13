package product.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewDto {
    private String comment;
    private CreateReviewProductDto product;
}

@Getter
@Setter
class CreateReviewProductDto {
    private Long id;
}