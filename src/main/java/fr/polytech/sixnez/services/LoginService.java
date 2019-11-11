package fr.polytech.sixnez.services;

import fr.polytech.sixnez.entities.UserEntity;
import fr.polytech.sixnez.repositories.UserRepository;
import fr.polytech.sixnez.security.CustomUserDetails;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomUserDetails userDetailsService;

    private HashMap<String, String> users;

    private Key key;

    private long expirationPlus;

    public LoginService(UserRepository userRepository,
                        CustomUserDetails userDetails) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetails;

        expirationPlus = 10_800_000; // 3 hours = 10 800 000 ms
        key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        users = new HashMap<>();

        users.put("Alex", "mypassword");
    }

    public String login(String username, String password) {

        UserEntity savedUser = userRepository.findByUsernameAndPassword(username, password);

        if (savedUser != null) {
            return Jwts.builder()
                    .setSubject(username)
                    .signWith(key)
                    .setExpiration(Date.from(Instant.now().plusMillis(expirationPlus)))
                    .compact();
        } else {
            return null;
        }
    }

    public void register(String username, String password) {

        userRepository.save(new UserEntity(username, password));
    }

    public Authentication parseToken(String token) throws JwtException {

        String username = Jwts.parser().parseClaimsJws(token).getBody().getSubject();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
