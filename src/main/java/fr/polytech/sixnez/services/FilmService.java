package fr.polytech.sixnez.services;

import fr.polytech.sixnez.dtos.ActeurDTO;
import fr.polytech.sixnez.dtos.FilmDTO;
import fr.polytech.sixnez.dtos.FilmDetailledDTO;
import fr.polytech.sixnez.dtos.PageDTO;
import fr.polytech.sixnez.entities.ActeurEntity;
import fr.polytech.sixnez.entities.CategorieEntity;
import fr.polytech.sixnez.entities.FilmEntity;
import fr.polytech.sixnez.entities.RoleEntity;
import fr.polytech.sixnez.repositories.CategorieRepository;
import fr.polytech.sixnez.repositories.FilmRepository;
import fr.polytech.sixnez.repositories.ProfessionRepository;
import fr.polytech.sixnez.repositories.RoleRepository;
import fr.polytech.sixnez.specifications.FilmSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public FilmService(FilmRepository filmRepository,
                       CategorieRepository categorieRepository,
                       RoleRepository roleRepository,
                       ProfessionRepository professionRepository,
                       FilmSpecification filmSpecification) {
        this.filmRepository = filmRepository;
        this.categorieRepository = categorieRepository;
        this.roleRepository = roleRepository;
        this.professionRepository = professionRepository;
    }

    public List<FilmDTO> getFilms(PageDTO page) {
        Pageable requestedPage = PageRequest.of(page.getPageNumber(), page.getPageSize());

        Page<FilmEntity> entities = filmRepository.findAll(filmSpecification.getFilmsByFilters(page.getFilter()), requestedPage);

        return entities.get().map(filmEntity -> new FilmDTO(filmEntity.getTitre(), filmEntity.getImage(), filmEntity.getIdFilm())).collect(Collectors.toList());
    }

    public FilmDetailledDTO getFilm(String id) {

        Optional<FilmEntity> filmEntity = filmRepository.findById(id);
        List<CategorieEntity> categorieEntities = categorieRepository.findByIdFilm(id);

        FilmDetailledDTO film = new FilmDetailledDTO();

        // TODO: C'est clairement too much le Optionnal pour faire ça.
        film.setTitle(filmEntity.orElse(new FilmEntity()).getTitre());
        film.setImgURL(filmEntity.orElse(new FilmEntity()).getImage());

        film.setCategories(categorieEntities.stream().map(categorieEntity -> categorieEntity.getGenre()).collect(Collectors.toList()));

        List<RoleEntity> roleEntities = roleRepository.findByIdFilm(id);
        List<ActeurEntity> acteurEntities = roleEntities.stream().map(roleEntity -> roleEntity.getActeurByIdActeur()).collect(Collectors.toList());

        List<ActeurDTO> acteursDTO = acteurEntities.stream().map(acteurEntity -> new ActeurDTO(acteurEntity.getIdActeur(), acteurEntity.getNomPrenom(), acteurEntity.getNaissance(), acteurEntity.getMort())).collect(Collectors.toList());
        acteursDTO.forEach(acteurDTO -> {
            List<String> metier = professionRepository.findByIdActeur(acteurDTO.getId()).stream().map(professionEntity -> professionEntity.getMetier()).collect(Collectors.toList());
            acteurDTO.setMetier(metier);
        });

        film.setActeurs(acteursDTO);

        return film;
    }

}
