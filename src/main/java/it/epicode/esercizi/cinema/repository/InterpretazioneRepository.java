package it.epicode.esercizi.cinema.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.epicode.esercizi.cinema.model.Artista;
import it.epicode.esercizi.cinema.model.Interpretazione;

public interface InterpretazioneRepository extends JpaRepository<Interpretazione,Long>{
	@Query("select c from Interpretazione c")
	public Page<Optional<Interpretazione>> getAll(Pageable page);
	
	public Optional<Interpretazione> findById(Long id);

	public Page<List<Interpretazione>> findByAttore(Artista attore,Pageable page);

}
