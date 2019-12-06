package fr.polytech.sixnez.controllers;

import fr.polytech.sixnez.services.LoginService;
import fr.polytech.sixnez.services.MetierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MetierController {

    private MetierService metierService;

    public MetierController(MetierService metierService) {
        this.metierService = metierService;
    }

    @GetMapping("/metiers")
    public ResponseEntity<List<String>> getMetiers() {
        return new ResponseEntity<List<String>>(metierService.getMetier(), HttpStatus.OK);
    }

}
