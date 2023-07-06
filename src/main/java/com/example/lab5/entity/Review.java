package com.example.lab5.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
    private int numberOfStars;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}