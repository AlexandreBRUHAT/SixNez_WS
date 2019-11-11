package fr.polytech.sixnez.repositories;

import fr.polytech.sixnez.entities.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<FilmEntity, String> {

    List<FilmEntity> findAllByOrderByTitre();
}
