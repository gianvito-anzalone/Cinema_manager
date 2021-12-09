package it.epicode.esercizi.cinema.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.esercizi.cinema.model.Generi;
import it.epicode.esercizi.cinema.repository.GeneriRepository;

@Service
public class GeneriService {

	@Autowired
	GeneriRepository generiRepo;
	
	public void saveGenere(Generi gen) {
		this.generiRepo.save(gen);
		
	}

	public void deleteGen(Long id) {
		this.generiRepo.deleteById(id);
	}

	public Page<Optional<Generi>> getAll(Pageable page){
		return this.generiRepo.getAll(page);
	}

	public Optional<Generi> getById(Long id) {
		return this.generiRepo.findById(id);
	}

}


