package com.miu.springsecurity.dto;

import lombok.Data;

@Data
public class AddressDto {
    private int id;
    private String street;
    private String zip;
    private String city;
}
