package lab4.security.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users",
        indexes = {
                @Index(name = "email_uniq_index", columnList = "email", unique = true)
        })
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;

    private String lastName;
    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;


    @OneToOne(mappedBy = "user")
    @JsonManagedReference
    private Address address;


    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

//    @JsonBackReference
//    @OneToMany(mappedBy = "user")
//    private List<Product> products;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> role.getName()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
