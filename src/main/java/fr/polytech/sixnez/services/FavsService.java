package fr.polytech.sixnez.services;

import fr.polytech.sixnez.dtos.FilmDTO;
import fr.polytech.sixnez.dtos.FilmIdDTO;
import fr.polytech.sixnez.entities.FavsEntity;
import fr.polytech.sixnez.repositories.FavsRepository;
import fr.polytech.sixnez.repositories.FilmRepository;
import fr.polytech.sixnez.specifications.FilmSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavsService {

    @Autowired
    private FavsRepository favsRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private LoginService loginService;

    @Autowired
    private FilmSpecification filmSpecification;

    public FavsService(FavsRepository favsRepository, LoginService loginService, FilmSpecification filmSpecification) {
        this.favsRepository = favsRepository;
        this.loginService = loginService;
        this.filmSpecification = filmSpecification;
    }

    public void setFavs(String id) {
        FavsEntity fav = new FavsEntity();
        fav.setUsername(loginService.getCurrentUser());
        fav.setIdFilm(id);

        favsRepository.save(fav);
    }

    public void deleteFavs(String id) {
        FavsEntity entity = favsRepository.findByIdFilmAndAndUsername(id, loginService.getCurrentUser());

        if (entity != null) {
            favsRepository.delete(entity);
        }
    }

    public List<FilmDTO> getFavs(Pageable pageable) {

        return filmRepository.findAll(filmSpecification.getFilmsByFavs(loginService.getCurrentUser()), pageable)
                .get()
                .map(filmEntity -> new FilmDTO(filmEntity.getTitre(), filmEntity.getImage(), filmEntity.getIdFilm(), true, filmEntity.getAnnee()))
                .collect(Collectors.toList());
    }

    public Boolean isFav(String id) {
        return favsRepository.findByIdFilmAndAndUsername(id, loginService.getCurrentUser()) != null;
    }
}
