package lab4.security.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SignupRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;



}
