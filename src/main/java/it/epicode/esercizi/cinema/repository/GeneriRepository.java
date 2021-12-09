package it.epicode.esercizi.cinema.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.epicode.esercizi.cinema.model.Generi;

public interface GeneriRepository extends JpaRepository<Generi,Long>{
	@Query("select c from Generi c")
	public Page<Optional<Generi>> getAll(Pageable page);

	public Optional<Generi> findById(Long id);
	
    

}
