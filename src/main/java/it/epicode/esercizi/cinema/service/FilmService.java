package it.epicode.esercizi.cinema.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.esercizi.cinema.model.Film;
import it.epicode.esercizi.cinema.repository.FilmRepository;

@Service
public class FilmService {
	
	@Autowired
	FilmRepository filmRepo;

	
	public void saveFilm(Film film) {
		this.filmRepo.save(film);
	}

	public void deleteFilm(Long id) {
		this.filmRepo.deleteById(id);
		
	}

	public Page<Optional<Film>> getAll(Pageable page){
		return this.filmRepo.getAll(page);
	}

	public Optional<Film> getById(Long id) {
		return this.filmRepo.findById(id);
	}



}
