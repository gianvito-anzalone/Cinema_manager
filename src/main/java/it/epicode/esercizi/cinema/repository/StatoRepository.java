package it.epicode.esercizi.cinema.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.epicode.esercizi.cinema.model.Stato;


public interface StatoRepository extends JpaRepository<Stato,Long>{
	@Query("SELECT c from Stato c")
	public Page<Optional<Stato>>getAll(Pageable page);

	public Optional<Stato>findById(Long id);
}
