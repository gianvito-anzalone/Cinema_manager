package it.epicode.esercizi.cinema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.esercizi.cinema.security.model.Role;
import it.epicode.esercizi.cinema.security.model.RoleType;

public interface RoleRepository extends JpaRepository<Role,Long>{

Optional<Role> findByRoles(RoleType roles);
	
	
}
