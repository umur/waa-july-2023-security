package com.waa.lab3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    private String rating;
    @OneToMany(mappedBy = "product")
    private List<Review> review;
    @ManyToOne
    private Category category;
}
