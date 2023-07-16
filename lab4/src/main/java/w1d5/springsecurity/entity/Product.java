package w1d5.springsecurity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private double price;

    private int rating;

    @JsonBackReference
    @ManyToOne
    private Category category;

    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.price, price) == 0 && rating == product.rating && name.equals(product.name) && category.equals(product.category) && reviews.equals(product.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, rating, category, reviews);
    }
}
