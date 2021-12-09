package it.epicode.esercizi.cinema.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.epicode.esercizi.cinema.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista,Long>{
	
	@Query("select c from Artista c")
	public Page<Optional<Artista>>getAll(Pageable page); 

	public Optional<Artista> findById(Long id);

    
}
