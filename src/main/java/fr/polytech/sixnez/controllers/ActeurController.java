package fr.polytech.sixnez.controllers;

import fr.polytech.sixnez.entities.ActeurEntity;
import fr.polytech.sixnez.services.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/acteurs")
public class ActeurController {

    @Autowired
    ActeurService acteurService;

    private ActeurController(ActeurService acteurService) {
        this.acteurService = acteurService;
    }

    @GetMapping("/acteurs")
    public List<ActeurEntity> getActeur(@RequestParam int page) {

        return acteurService.getActeurs(page);
    }
}
