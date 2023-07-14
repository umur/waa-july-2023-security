package cs545.springData.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;
    private String rating;
//    @JsonBackReference
    @ManyToOne
    private Category category;
//    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List <Review> review;

}

