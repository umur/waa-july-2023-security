package product.dto.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressDto {

    private String street;

    private String zip;

    private String city;
}
