package it.epicode.esercizi.cinema.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.esercizi.cinema.model.Stato;
import it.epicode.esercizi.cinema.repository.StatoRepository;

@Service
public class StatoService {
	
	@Autowired
	StatoRepository statRepo;


	public void saveStat(Stato nazione) {
		this.statRepo.save(nazione);
	}


	public void deleteStat(Long id) {
		this.statRepo.deleteById(id);
	}


	public Page<Optional<Stato>> getAll(Pageable page){
		return this.statRepo.getAll(page);
	}

	public Optional<Stato>getbyId(Long id){
		return this.statRepo.findById(id);
	}



}
