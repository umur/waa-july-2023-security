package product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private int rating;

    @ManyToOne
    @JsonManagedReference
    private Category category;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<Review> reviews;

    @ManyToOne
    private User user;

}
