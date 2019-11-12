package fr.polytech.sixnez.controllers;

import fr.polytech.sixnez.dtos.FilmsDTO;
import fr.polytech.sixnez.dtos.PageDTO;
import fr.polytech.sixnez.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public List<FilmsDTO> getFilms(@RequestBody PageDTO page) {
        return filmService.getFilms(page);
    }
}
