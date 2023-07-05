package cs545.Domain.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String email;
    private String password;

}
