package cs545.springData.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;
//    @JsonBackReference
    @ManyToOne
    private User user;
//    @JsonBackReference
    @ManyToOne
    private Product product;
}
