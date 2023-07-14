package cs545.springData.security;

import cs545.springData.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final cs545.springData.entity.User customer = userRepo.findUserByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException("Email not found with email address: " + email);
        }
        UserDetails user = User.withUsername(customer.getEmail())
                .password(customer.getPassword()).build();
        return user;
    }
}
