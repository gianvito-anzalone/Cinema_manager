package it.epicode.esercizi.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.esercizi.cinema.model.Artista;
import it.epicode.esercizi.cinema.model.Interpretazione;
import it.epicode.esercizi.cinema.repository.InterpretazioneRepository;

@Service
public class InterpretazioneService {
	
	@Autowired
	InterpretazioneRepository interRepo; 
	
	public void saveInter(Interpretazione inte) {
		this.interRepo.save(inte);
	}

	public void deleteInterId(Long id) {
		this.interRepo.deleteById(id);
	}

	public Page<Optional<Interpretazione>> findAll(Pageable page){
		return this.interRepo.getAll(page);
	}

	public Optional<Interpretazione> findById(Long id){
		return this.interRepo.findById(id);
	}

	public Page<List<Interpretazione>> findfilmbyattore(Artista artista,Pageable page){
		return this.interRepo.findByAttore(artista, page);
		
	}
}
