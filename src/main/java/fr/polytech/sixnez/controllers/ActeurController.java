package fr.polytech.sixnez.controllers;

import fr.polytech.sixnez.dtos.ActeurDTO;
import fr.polytech.sixnez.dtos.ActeurDetailledDTO;
import fr.polytech.sixnez.entities.ActeurEntity;
import fr.polytech.sixnez.services.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController("/acteurs")
public class ActeurController {

    @Autowired
    ActeurService acteurService;

    private ActeurController(ActeurService acteurService) {
        this.acteurService = acteurService;
    }

    @GetMapping("/acteurs")
    public ResponseEntity<List<ActeurDTO>> getActeurs(Pageable page, @RequestParam Optional<String> like, @RequestParam Optional<String> metier) {

        return new ResponseEntity<>(acteurService.getActeurs(page, like.orElse(null), metier.orElse(null)), HttpStatus.OK);
    }

    @GetMapping("/acteurs/{id}")
    public ResponseEntity<ActeurDetailledDTO> getActeur(@PathVariable("id") String id) {

        return new ResponseEntity<>(acteurService.getActeur(id), HttpStatus.OK);
    }
}
