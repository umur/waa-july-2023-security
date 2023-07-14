package com.waa.lab3.securityEntities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse   {
    private final String token;

    public JwtResponse(String token) {
        this.token = token;
    }
}
