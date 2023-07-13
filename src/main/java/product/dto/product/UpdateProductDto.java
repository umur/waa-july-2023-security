package product.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductDto {

    private Long id;
    private String name;
    private int rating;
    private double price;
    private UpdateProductCategoryDto category;
}


@Getter
@Setter
class UpdateProductCategoryDto {
    private Long id;
}