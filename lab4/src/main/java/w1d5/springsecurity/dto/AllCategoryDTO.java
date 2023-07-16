package w1d5.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;
import w1d5.springsecurity.entity.Product;

import java.util.List;

@Getter
@Setter
public class AllCategoryDTO {
    private long id;

    private String name;

    private List<Product> products;
}
