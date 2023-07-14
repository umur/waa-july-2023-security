package cs545.springData.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class UserRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
