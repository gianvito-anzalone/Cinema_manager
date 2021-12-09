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

import it.epicode.esercizi.cinema.model.Generi;
import it.epicode.esercizi.cinema.service.GeneriService;

@RestController
@RequestMapping("/apigeneri")
public class GeneriController {

	@Autowired
	GeneriService service;

	@PostMapping("/savegen")
	public void saveGen(@RequestBody Generi gen) {
		this.service.saveGenere(gen);
	}

	@GetMapping("/deletegen")
	public void deleteGen(@RequestParam Long id) {
		this.service.deleteGen(id);
	}


	@GetMapping("/getall")
	public ResponseEntity<?> getAll(Pageable page){
		Page<Optional<Generi>> find=this.service.getAll(page);
		if(find.hasContent())
			return new ResponseEntity<>(find,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
	}

	@GetMapping("/getbyid")
	public ResponseEntity<Optional<Generi>> getById(@RequestParam Long id) {
		Optional<Generi> find=this.service.getById(id);
		if(find.isPresent())
			return new ResponseEntity<>(find,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
	}



}
