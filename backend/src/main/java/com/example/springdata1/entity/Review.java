package com.example.springdata1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn
    @MapsId("user_id")
    private User user;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    @MapsId("product_id")
    private Product product;

    public Review() {
    }
}
