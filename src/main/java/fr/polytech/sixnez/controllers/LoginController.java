package fr.polytech.sixnez.controllers;

import fr.polytech.sixnez.services.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/login")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return loginService.login(username, password);
    }

    @PutMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        loginService.register(username, password);

        return "OK";
    }
}
