package fr.polytech.sixnez.services;

import fr.polytech.sixnez.dtos.ActeurDTO;
import fr.polytech.sixnez.dtos.FilterActeurDTO;
import fr.polytech.sixnez.dtos.PageDTO;
import fr.polytech.sixnez.entities.ActeurEntity;
import fr.polytech.sixnez.repositories.ActeurRepository;
import fr.polytech.sixnez.specifications.ActeurSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<ActeurDTO> getActeurs(PageDTO page) {

        Pageable requestedPage = PageRequest.of(page.getPageNumber(), page.getPageSize());


        Page<ActeurEntity> entities = acteurRepository.findAll(acteurSpecification.getActeursByFilters((FilterActeurDTO)page.getFilter()), requestedPage);

        return entities.get().map(acteurEntity -> new ActeurDTO(acteurEntity.getIdActeur(), acteurEntity.getNomPrenom())).collect(Collectors.toList());
    }

    public ActeurEntity getActeur(int id) {

        return acteurRepository.findByIdActeur(id);
    }
}
