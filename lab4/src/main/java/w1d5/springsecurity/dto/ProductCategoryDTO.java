package w1d5.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;
import w1d5.springsecurity.entity.Category;
import w1d5.springsecurity.entity.Product;

import java.util.List;

@Getter
@Setter
public class ProductCategoryDTO {

    private Category category;

    private List<Product> products;
}
