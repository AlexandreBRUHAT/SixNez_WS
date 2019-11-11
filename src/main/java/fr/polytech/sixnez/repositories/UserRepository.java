package fr.polytech.sixnez.repositories;

import fr.polytech.sixnez.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    public UserEntity findByUsername(String username);

    public UserEntity findByUsernameAndPassword(String username, String password);
}
