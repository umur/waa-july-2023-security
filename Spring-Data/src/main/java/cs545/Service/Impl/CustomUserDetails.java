package cs545.Service.Impl;


import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {
    private Integer id;

    public CustomUserDetails(UserDetails userDetails) {
        super(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}


