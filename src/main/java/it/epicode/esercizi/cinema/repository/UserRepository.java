package it.epicode.esercizi.cinema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import it.epicode.esercizi.cinema.security.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	Optional<User> findByUsername(String username);

	boolean existsByUsername(String username);
	
	boolean existsByEmail(String email);
}
