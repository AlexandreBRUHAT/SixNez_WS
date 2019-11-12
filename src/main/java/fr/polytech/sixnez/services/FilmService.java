package fr.polytech.sixnez.services;

import fr.polytech.sixnez.dtos.FilmsDTO;
import fr.polytech.sixnez.dtos.PageDTO;
import fr.polytech.sixnez.entities.FilmEntity;
import fr.polytech.sixnez.repositories.FilmRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<FilmsDTO> getFilms(PageDTO page) {
        Pageable requestedPage = PageRequest.of(page.getPageNumber(), page.getPageSize());
        List<FilmEntity> entities = filmRepository.findAllByOrderByTitre(requestedPage);

        return entities.stream().map(filmEntity -> new FilmsDTO(filmEntity.getTitre(), filmEntity.getImage())).collect(Collectors.toList());
    }

}
