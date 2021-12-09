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

import it.epicode.esercizi.cinema.model.Stato;
import it.epicode.esercizi.cinema.service.StatoService;

@RestController
@RequestMapping("/apistato")
public class StatoController {

	@Autowired
	StatoService service;
	
	@PostMapping("/savefilm")
	public void saveFilm(@RequestBody Stato stat) {
		this.service.saveStat(stat);
	}

	@GetMapping("/deletefilm")
	public void deleteFilm(@RequestParam Long id) {
		this.service.deleteStat(id);

	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll(Pageable page) {
		Page<Optional<Stato>> find = this.service.getAll(page);
		if (find.hasContent())
			return new ResponseEntity<>(find, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

	}

	@GetMapping("/getbyid")
	public ResponseEntity<?> getbyId(@RequestParam Long id) {
		Optional<Stato> find = this.service.getbyId(id);
		if (find.isPresent())
			return new ResponseEntity<>(find, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
}
