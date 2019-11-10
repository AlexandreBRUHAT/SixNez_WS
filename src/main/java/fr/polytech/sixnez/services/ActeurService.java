package fr.polytech.sixnez.services;

import fr.polytech.sixnez.entities.ActeurEntity;
import fr.polytech.sixnez.repositories.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActeurService {

    @Autowired
    ActeurRepository acteurRepository;

    private ActeurService(ActeurRepository acteurRepository) {
        this.acteurRepository = acteurRepository;
    }

    public List<ActeurEntity> getActeurs(int page) {

        return acteurRepository.findAllByOrderByNomPrenomAsc(PageRequest.of(page, 25)).getContent();
    }
}
