package product.dto.user;

import lombok.Getter;
import lombok.Setter;
import product.dto.address.CreateAddressDto;

@Getter
@Setter
public class UpdateUserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    private CreateAddressDto address;
}
