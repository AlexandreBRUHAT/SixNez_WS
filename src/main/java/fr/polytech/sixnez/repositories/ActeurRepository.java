package fr.polytech.sixnez.repositories;

import fr.polytech.sixnez.entities.ActeurEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepository extends JpaRepository<ActeurEntity, String> {

    Page<ActeurEntity> findAllByOrderByNomPrenomAsc(Pageable pageable);
}
