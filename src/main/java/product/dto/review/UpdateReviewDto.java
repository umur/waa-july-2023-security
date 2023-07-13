package product.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateReviewDto {
    private Long id;
    private String comment;
}