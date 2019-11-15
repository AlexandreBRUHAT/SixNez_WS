package fr.polytech.sixnez.controllers;

import fr.polytech.sixnez.dtos.FilmDTO;
import fr.polytech.sixnez.dtos.FilmDetailledDTO;
import fr.polytech.sixnez.dtos.PageDTO;
import fr.polytech.sixnez.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public ResponseEntity<List<FilmDTO>> getFilms(@RequestBody PageDTO page) {
        return new ResponseEntity<>(filmService.getFilms(page), HttpStatus.OK);
    }

    @GetMapping("/films/{id}")
    public ResponseEntity<FilmDetailledDTO> getFilm(@PathVariable("id") String id) {
        return new ResponseEntity<>(filmService.getFilm(id), HttpStatus.OK);
    }
}
