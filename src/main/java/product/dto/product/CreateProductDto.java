package product.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
    private String name;
    private int rating;
    private double price;
    private CreateProductCategoryDto category;
}


@Getter
@Setter
class CreateProductCategoryDto {
    private Long id;
}