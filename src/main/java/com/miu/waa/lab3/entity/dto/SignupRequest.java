package com.miu.waa.lab3.entity.dto;

import com.miu.waa.lab3.entity.Address;

import lombok.Data;

@Data
public class SignupRequest {
    private String email;
    private String password;
    private String retypePassword;
    private String firstName;
    private String lastName;
    private Address address;
}
