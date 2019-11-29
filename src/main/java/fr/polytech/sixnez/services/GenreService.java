package fr.polytech.sixnez.services;

import fr.polytech.sixnez.repositories.CategorieRepository;
import fr.polytech.sixnez.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    GenreRepository repository;

    public GenreService(GenreRepository genreRepository) {
        this.repository = genreRepository;
    }

    public List<String> getListGenres() {
        return repository.findAll().stream().map(genreEntity -> genreEntity.getGenre()).collect(Collectors.toList());
    }
}
