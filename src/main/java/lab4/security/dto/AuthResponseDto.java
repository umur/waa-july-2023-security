package lab4.security.dto;

import lab4.security.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Role> roles;
    private String token;

}
