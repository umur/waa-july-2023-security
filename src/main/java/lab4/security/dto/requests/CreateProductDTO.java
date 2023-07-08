package lab4.security.dto.requests;

import lombok.Data;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@Builder
public class CreateProductDTO {
    private String name;
    private String description;
    private float rating;
    private int price;
    private Long category_id;
}
