package fr.polytech.sixnez.repositories;

import fr.polytech.sixnez.entities.MetierEntity;
import fr.polytech.sixnez.entities.ProfessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetierRepository extends JpaRepository<MetierEntity, String> {
}
