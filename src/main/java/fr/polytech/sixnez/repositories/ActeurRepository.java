package fr.polytech.sixnez.repositories;

import fr.polytech.sixnez.entities.ActeurEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface ActeurRepository extends Repository<ActeurEntity, String> {

    Page<ActeurEntity> findAllByOrderByNomPrenomAsc(Pageable pageable);
}
