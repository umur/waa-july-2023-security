package product.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String comment;

    @ManyToOne
    @JsonManagedReference
    private Product product;

    @ManyToOne
    @JsonManagedReference
    private User user;
}
