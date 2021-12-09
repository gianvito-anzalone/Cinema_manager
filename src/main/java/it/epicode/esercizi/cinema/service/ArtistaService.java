package it.epicode.esercizi.cinema.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.esercizi.cinema.model.Artista;
import it.epicode.esercizi.cinema.repository.ArtistaRepository;

@Service
public class ArtistaService {

	@Autowired
	ArtistaRepository artRepo;
	
	public Page<Optional<Artista>> findAll(Pageable page){
		return this.artRepo.getAll(page);
	}


	public Artista findbyId(Long id) {
		return this.artRepo.getById(id);
	}


	public void saveArt(Artista art) {
		this.artRepo.save(art);
	}


	public void deleteArt(Long id) {
		this.artRepo.deleteById(id);
	}

}
