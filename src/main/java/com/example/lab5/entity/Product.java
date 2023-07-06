package com.example.lab5.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;

    @JsonBackReference
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @ManyToOne
    private User user;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}