package fr.polytech.sixnez.repositories;

import fr.polytech.sixnez.entities.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategorieRepository extends JpaRepository<CategorieEntity, String> {

    public List<CategorieEntity> findByIdFilm(String id);
}
