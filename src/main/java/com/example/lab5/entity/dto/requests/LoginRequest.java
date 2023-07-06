package com.example.lab5.entity.dto.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    private String userName;
    private String password;
}
