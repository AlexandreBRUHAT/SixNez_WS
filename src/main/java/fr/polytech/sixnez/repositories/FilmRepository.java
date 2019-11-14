package fr.polytech.sixnez.repositories;

import fr.polytech.sixnez.entities.FilmEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface FilmRepository extends JpaRepository<FilmEntity, String>, JpaSpecificationExecutor<FilmEntity> {

    List<FilmEntity> findAllByOrderByTitre(Pageable page);
}
