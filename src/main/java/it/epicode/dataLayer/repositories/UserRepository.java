package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {

    Optional<User> findOneByUsernameAndPassword(String username, String password);
    Optional<User> findOneByEmail(String email);
    Optional<User> findOneByUsername(String username);
}
