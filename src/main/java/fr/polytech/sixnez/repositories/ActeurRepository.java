package fr.polytech.sixnez.repositories;

import fr.polytech.sixnez.entities.ActeurEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActeurRepository extends JpaRepository<ActeurEntity, String>, JpaSpecificationExecutor<ActeurEntity> {

    ActeurEntity findByIdActeur(String id);
}
