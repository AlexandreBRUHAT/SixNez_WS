package fr.polytech.sixnez.repositories;

import fr.polytech.sixnez.entities.FavsEntity;
import fr.polytech.sixnez.entities.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavsRepository extends JpaRepository<FavsEntity, String>, JpaSpecificationExecutor<FavsEntity> {

    FavsEntity findByIdFilmAndAndUsername(String id, String username);
}
