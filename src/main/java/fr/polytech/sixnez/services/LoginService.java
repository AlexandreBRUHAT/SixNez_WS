package fr.polytech.sixnez.services;

import fr.polytech.sixnez.entities.UserEntity;
import fr.polytech.sixnez.exceptions.SNException;
import fr.polytech.sixnez.exceptions.SpecialCode;
import fr.polytech.sixnez.properties.AppProperties;
import fr.polytech.sixnez.repositories.UserRepository;
import fr.polytech.sixnez.security.CustomUserDetails;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Date;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomUserDetails userDetailsService;
    @Autowired
    private AppProperties appProperties;

    private String key;
    private SignatureAlgorithm algorithm;
    @Autowired
    private PasswordEncoder encoder;

    private long expirationPlus;

    public LoginService(UserRepository userRepository,
                        CustomUserDetails userDetails,
                        AppProperties appProperties,
                        PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetails;
        this.appProperties = appProperties;
        this.encoder = passwordEncoder;

        expirationPlus = 10_800_000; // 3 hours = 10 800 000 ms

        key = appProperties.getSecret();
        algorithm = SignatureAlgorithm.HS256;
    }

    // METHODS FOR CONTROLLER

    public String login(String username, String password) {

        UserEntity savedUser = userRepository.findByUsername(username);

        if (encoder.matches(password, savedUser.getPassword())) {
            return Jwts.builder()
                    .setSubject(username)
                    .signWith(algorithm, key)
                    .setExpiration(Date.from(Instant.now().plusMillis(expirationPlus)))
                    .compact();
        } else {
            throw new SNException("Bad credentials !", HttpStatus.BAD_REQUEST, SpecialCode.LOGIN_BAD_CREDENTIALS);
        }
    }



    // METHODS FOR SECURITY


    public void register(String username, String password) {

        if (userRepository.findByUsername(username) != null) {
            throw new SNException("Username already exists !", HttpStatus.BAD_REQUEST, SpecialCode.LOGIN_USERNAME_ALREADY_EXISTS);
        }

        password = encoder.encode(password);

        UserEntity user = new UserEntity(username, password);
        userRepository.save(user);
    }

    public Authentication parseToken(String token) throws JwtException {

        String username = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();

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

    // Method for services

    public String getCurrentUser() {
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userDetails.getUsername();
    }
}
