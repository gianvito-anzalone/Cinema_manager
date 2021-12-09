package it.epicode.esercizi.cinema.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.epicode.esercizi.cinema.model.Film;

public interface FilmRepository extends JpaRepository<Film,Long>{
	@Query("select c from Film c")
	Page<Optional<Film>> getAll(Pageable page);

	Optional<Film> findById(Long id);
	
	
}
