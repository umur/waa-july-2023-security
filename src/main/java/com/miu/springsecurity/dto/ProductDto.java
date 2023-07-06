package com.miu.springsecurity.dto;

import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private int rating;
}
