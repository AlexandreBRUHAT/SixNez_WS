package fr.polytech.sixnez.services;

import fr.polytech.sixnez.dtos.*;
import fr.polytech.sixnez.entities.ActeurEntity;
import fr.polytech.sixnez.entities.CategorieEntity;
import fr.polytech.sixnez.entities.FilmEntity;
import fr.polytech.sixnez.entities.RoleEntity;
import fr.polytech.sixnez.exceptions.SNException;
import fr.polytech.sixnez.exceptions.SpecialCode;
import fr.polytech.sixnez.repositories.CategorieRepository;
import fr.polytech.sixnez.repositories.FilmRepository;
import fr.polytech.sixnez.repositories.ProfessionRepository;
import fr.polytech.sixnez.repositories.RoleRepository;
import fr.polytech.sixnez.specifications.FilmSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ProfessionRepository professionRepository;
    @Autowired
    private FilmSpecification filmSpecification;
    @Autowired
    private FavsService favsService;

    public FilmService(FilmRepository filmRepository,
                       CategorieRepository categorieRepository,
                       RoleRepository roleRepository,
                       ProfessionRepository professionRepository,
                       FilmSpecification filmSpecification,
                       FavsService favsService) {
        this.filmRepository = filmRepository;
        this.categorieRepository = categorieRepository;
        this.roleRepository = roleRepository;
        this.professionRepository = professionRepository;
        this.favsService = favsService;
    }

    public List<FilmDTO> getFilms(Pageable page, String genre, String like, int annee) {

        page = PageRequest.of(page.getPageNumber(), page.getPageSize(), Sort.by("annee").descending());

        Page<FilmEntity> entities = filmRepository.findAll(filmSpecification.getFilmsByFilters(genre, like, annee), page);

        return entities.get().map(filmEntity -> new FilmDTO(filmEntity.getTitre(), filmEntity.getImage(), filmEntity.getIdFilm(), favsService.isFav(filmEntity.getIdFilm()), filmEntity.getAnnee())).collect(Collectors.toList());
    }

    public FilmDetailledDTO getFilm(String id) {

        Optional<FilmEntity> filmEntity = filmRepository.findById(id);
        List<CategorieEntity> categorieEntities = categorieRepository.findByIdFilm(id);

        if (!filmEntity.isPresent()) {
            throw new SNException("Film not found.", HttpStatus.NOT_FOUND, SpecialCode.FILM_NOT_FOUND);
        }

        FilmDetailledDTO film = new FilmDetailledDTO();

        // TODO: C'est clairement too much le Optionnal pour faire ça. Mais c'est la méthode par défaut qui retourne un Optional
        film.setTitle(filmEntity.orElse(new FilmEntity()).getTitre());
        film.setImgURL(filmEntity.orElse(new FilmEntity()).getImage());
        film.setAnnee(filmEntity.orElse(new FilmEntity()).getAnnee());
        film.setFav(favsService.isFav(filmEntity.orElse(new FilmEntity()).getIdFilm()));

        film.setCategories(categorieEntities.stream().map(categorieEntity -> categorieEntity.getGenre()).collect(Collectors.toList()));

        List<RoleEntity> roleEntities = roleRepository.findByIdFilm(id);
        List<ActeurEntity> acteurEntities = roleEntities.stream().map(roleEntity -> roleEntity.getActeurByIdActeur()).collect(Collectors.toList());

        List<ActeurFilmDTO> acteursDTO = acteurEntities.stream().map(acteurEntity -> new ActeurFilmDTO(acteurEntity.getIdActeur(), acteurEntity.getNomPrenom())).collect(Collectors.toList());
        acteursDTO.forEach(acteurFilmDTO -> {
            List<String> metier = professionRepository.findByIdActeur(acteurFilmDTO.getId()).stream().map(professionEntity -> professionEntity.getMetier()).collect(Collectors.toList());
            acteurFilmDTO.setMetier(metier);
        });

        film.setActeurs(acteursDTO);

        return film;
    }

}
