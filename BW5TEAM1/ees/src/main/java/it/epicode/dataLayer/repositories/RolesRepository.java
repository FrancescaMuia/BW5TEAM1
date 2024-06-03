package it.epicode.dataLayer.repositories;

import it.epicode.dataLayer.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findOneByName(String nomeRuolo);
}
