package fr.polytech.sixnez.controllers;

import fr.polytech.sixnez.dtos.FilmIdDTO;
import fr.polytech.sixnez.services.FavsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavsController {

    @Autowired
    private FavsService favsService;

    public FavsController(FavsService favsService) {
        this.favsService = favsService;
    }

    @PostMapping("/favs")
    public ResponseEntity setFavs(@RequestBody FilmIdDTO id) {
        favsService.setFavs(id.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/favs")
    public ResponseEntity deleteFavs(@RequestBody FilmIdDTO id) {
        favsService.deleteFavs(id.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/favs")
    public ResponseEntity<List<FilmIdDTO>> getFavs(Pageable pageable) {
        return new ResponseEntity<>(favsService.getFavs(pageable), HttpStatus.OK);
    }
}
