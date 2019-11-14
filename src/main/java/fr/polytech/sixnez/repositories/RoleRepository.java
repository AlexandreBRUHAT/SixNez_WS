package fr.polytech.sixnez.repositories;

import fr.polytech.sixnez.entities.RoleEntity;
import fr.polytech.sixnez.entities.RoleEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity, RoleEntityPK> {

    public List<RoleEntity> findByIdFilm(String id);
}
