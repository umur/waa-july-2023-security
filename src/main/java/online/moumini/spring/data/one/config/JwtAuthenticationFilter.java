package online.moumini.spring.data.one.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    private final JwtUtilityService jwtUtilityService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                System.out.println("*************** this filter is executed ****************");
        final String authorizationHeader = request.getHeader("Authorization");
        final String token;
        final String username;
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        token = authorizationHeader.substring(7);
        username = jwtUtilityService.extractClaim(token, Claims::getSubject);
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if (jwtUtilityService.isTokenValid(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    /*
     * @Override
     * protected void configure(HttpSecurity http) throws Exception {
     * http.csrf().disable();
     * http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
     * STATELESS);
     * http.formLogin();
     * http.authorizeHttpRequests().anyRequest().authenticated();
     * }
     * 
     * @Override
     * protected void configure(AuthenticationManagerBuilder auth) throws Exception
     * {
     * auth.userDetailsService(new UserDetailsService() {
     * 
     * @Override
     * public UserDetails loadUserByUsername(String username) throws
     * UsernameNotFoundException {
     * System.out.println(username);
     * AppUser user = userRepository.findByUsername(username).get();
     * System.out.println(user);
     * 
     * List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
     * .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
     * .collect(Collectors.toList());
     * 
     * return new User(user.getUsername(), user.getPassword(), authorities);
     * }
     * });
     * }
     */
}
