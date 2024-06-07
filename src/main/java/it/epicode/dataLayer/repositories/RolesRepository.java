package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Role, Long>, PagingAndSortingRepository<Role, Long> {
    Optional<Role> findOneByName(String roleName);
}

