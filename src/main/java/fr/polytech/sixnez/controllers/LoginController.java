package fr.polytech.sixnez.controllers;

import fr.polytech.sixnez.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        return new ResponseEntity<String>(loginService.login(username, password), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username, @RequestParam String password) {
        loginService.register(username, password);

        return new ResponseEntity<String>("You're registered.", HttpStatus.OK);
    }
}
