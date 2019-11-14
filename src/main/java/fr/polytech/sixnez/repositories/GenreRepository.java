package fr.polytech.sixnez.repositories;

import fr.polytech.sixnez.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreEntity, String> {
}
