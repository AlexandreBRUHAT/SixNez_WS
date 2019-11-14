package fr.polytech.sixnez.repositories;

import fr.polytech.sixnez.entities.ProfessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessionRepository extends JpaRepository<ProfessionEntity, String> {

    public List<ProfessionEntity> findByIdActeur(String id);
}
