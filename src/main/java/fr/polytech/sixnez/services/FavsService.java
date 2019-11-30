package fr.polytech.sixnez.services;

import fr.polytech.sixnez.dtos.FilmIdDTO;
import fr.polytech.sixnez.entities.FavsEntity;
import fr.polytech.sixnez.repositories.FavsRepository;
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
    private LoginService loginService;

    public FavsService(FavsRepository favsRepository, LoginService loginService) {
        this.favsRepository = favsRepository;
        this.loginService = loginService;
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

    public List<FilmIdDTO> getFavs(Pageable pageable) {
        return favsRepository.findAll(pageable).get().map(favsEntity -> new FilmIdDTO(favsEntity.getIdFilm())).collect(Collectors.toList());
    }

    public Boolean isFav(String id) {
        return favsRepository.findByIdFilmAndAndUsername(id, loginService.getCurrentUser()) != null;
    }
}
