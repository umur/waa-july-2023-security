package w1d5.springsecurity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String comment;

    @JsonBackReference
    @ManyToOne
    private User user;

    @JsonBackReference
    @ManyToOne
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && comment.equals(review.comment) && user.equals(review.user) && product.equals(review.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, user, product);
    }
}
