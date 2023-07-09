package Demo1.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    private String comment;
    private int numberOfStars;

  @ManyToOne
    Product product;

}
