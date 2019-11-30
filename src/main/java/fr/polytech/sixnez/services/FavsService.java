package fr.polytech.sixnez.services;

import fr.polytech.sixnez.entities.FavsEntity;
import fr.polytech.sixnez.repositories.FavsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
