package fr.polytech.sixnez.services;

import fr.polytech.sixnez.dtos.ActeurDTO;
import fr.polytech.sixnez.dtos.ActeurDetailledDTO;
import fr.polytech.sixnez.dtos.FilmDTO;
import fr.polytech.sixnez.entities.ActeurEntity;
import fr.polytech.sixnez.entities.FilmEntity;
import fr.polytech.sixnez.repositories.ActeurRepository;
import fr.polytech.sixnez.specifications.ActeurSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActeurService {

    @Autowired
    ActeurRepository acteurRepository;
    @Autowired
    ActeurSpecification acteurSpecification;

    private ActeurService(ActeurRepository acteurRepository, ActeurSpecification acteurSpecification) {
        this.acteurRepository = acteurRepository;
        this.acteurSpecification = acteurSpecification;
    }

    public List<ActeurDTO> getActeurs(Pageable page, String like, String metier) {

        Page<ActeurEntity> entities = acteurRepository.findAll(acteurSpecification.getActeursByFilters(like, metier), page);

        return entities.get().map(acteurEntity -> new ActeurDTO(acteurEntity.getIdActeur(), acteurEntity.getNomPrenom())).collect(Collectors.toList());
    }

    public ActeurDetailledDTO getActeur(String id) {

        ActeurEntity entity = acteurRepository.findByIdActeur(id);

        List<FilmEntity> films = entity.getRolesByIdActeur().stream().map(roleEntity -> roleEntity.getFilmByIdFilm()).collect(Collectors.toList());

        return new ActeurDetailledDTO(entity.getIdActeur(),
                entity.getNomPrenom(),
                entity.getNaissance(),
                entity.getMort(),
                entity.getProfessionsByIdActeur().stream().map(professionEntity -> professionEntity.getMetier()).collect(Collectors.toList()),
                films.stream().map(filmEntity -> new FilmDTO(filmEntity.getTitre(), filmEntity.getImage(), filmEntity.getIdFilm())).collect(Collectors.toList()));
    }
}
