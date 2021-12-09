package it.epicode.esercizi.cinema.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.esercizi.cinema.model.Film;
import it.epicode.esercizi.cinema.service.FilmService;

@RestController
@RequestMapping("/apifilm")
public class FilmController {

	@Autowired
	FilmService service;

	@PostMapping("/savefilm")
	public void saveFilm(@RequestBody Film film) {
		this.service.saveFilm(film);
	}

	@GetMapping("/deletefilm")
	public void deleteFilm(@RequestParam Long id) {
		this.service.deleteFilm(id);

	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll(Pageable page) {
		Page<Optional<Film>> find = this.service.getAll(page);
		if (find.hasContent())
			return new ResponseEntity<>(find, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

	}

	@GetMapping("/getbyid")
	public ResponseEntity<?> getbyId(@RequestParam Long id) {
		Optional<Film> find = this.service.getById(id);
		if (find.isPresent())
			return new ResponseEntity<>(find, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
}