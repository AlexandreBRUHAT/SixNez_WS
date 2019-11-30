package fr.polytech.sixnez.controllers;

import fr.polytech.sixnez.dtos.FilmIdDTO;
import fr.polytech.sixnez.services.FavsService;
import fr.polytech.sixnez.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FavsController {

    @Autowired
    private FavsService favsService;

    public FavsController(FavsService favsService) {
        this.favsService = favsService;
    }

    @PostMapping("/favs")
    private ResponseEntity setFavs(@RequestBody FilmIdDTO id) {
        favsService.setFavs(id.getId());
        return new ResponseEntity(HttpStatus.OK);
    }
}
