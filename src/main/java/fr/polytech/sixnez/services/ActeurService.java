package fr.polytech.sixnez.services;

import fr.polytech.sixnez.dtos.ActeurDTO;
import fr.polytech.sixnez.dtos.ActeurDetailledDTO;
import fr.polytech.sixnez.dtos.FilmActeurDTO;
import fr.polytech.sixnez.dtos.FilmDTO;
import fr.polytech.sixnez.entities.ActeurEntity;
import fr.polytech.sixnez.entities.FilmEntity;
import fr.polytech.sixnez.exceptions.SNException;
import fr.polytech.sixnez.exceptions.SpecialCode;
import fr.polytech.sixnez.repositories.ActeurRepository;
import fr.polytech.sixnez.specifications.ActeurSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

        if (entity == null) {
            throw new SNException("Actor not found.", HttpStatus.NOT_FOUND, SpecialCode.ACTOR_NOT_FOUND);
        }

        List<FilmEntity> films = entity.getRolesByIdActeur().stream().map(roleEntity -> roleEntity.getFilmByIdFilm()).collect(Collectors.toList());



        return new ActeurDetailledDTO(entity.getIdActeur(),
                entity.getNomPrenom(),
                entity.getNaissance(),
                entity.getMort(),
                entity.getProfessionsByIdActeur().stream().map(professionEntity -> professionEntity.getMetier()).collect(Collectors.toList()),
                films.stream().map(filmEntity -> new FilmActeurDTO(filmEntity.getTitre(), filmEntity.getIdFilm())).collect(Collectors.toList()));
    }
}
