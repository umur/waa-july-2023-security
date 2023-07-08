package lab4.security.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private float rating;
    private int price;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

//    @JsonManagedReference
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
}
