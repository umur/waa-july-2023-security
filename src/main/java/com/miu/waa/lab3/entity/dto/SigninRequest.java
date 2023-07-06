package com.miu.waa.lab3.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SigninRequest {
    private String email;
    private String password;
}
