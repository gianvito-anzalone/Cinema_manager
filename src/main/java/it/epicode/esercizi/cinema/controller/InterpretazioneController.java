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

import it.epicode.esercizi.cinema.model.Interpretazione;
import it.epicode.esercizi.cinema.service.InterpretazioneService;

@RestController
@RequestMapping("/apiInterpretazione")
public class InterpretazioneController {
	
	@Autowired
	InterpretazioneService service;


	@PostMapping("/saveint")
	public void saveInter(@RequestBody Interpretazione inte) {
		this.service.saveInter(inte);
	}


	@GetMapping("/deletebyid")
	public void delete(@RequestParam Long id) {
		this.service.deleteInterId(id);
	}


	@GetMapping("/getbyid")
	public ResponseEntity<Optional<Interpretazione>> getbyId(@RequestParam Long id){
		Optional<Interpretazione> find=this.service.findById(id);
		if(find.isPresent())
			return new ResponseEntity<Optional<Interpretazione>>(find,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
	}

	@GetMapping("/getall")
	public ResponseEntity<?>getAll(Pageable page){
		Page<Optional<Interpretazione>> find=this.service.findAll(page);
		if(find.hasContent())
			return new ResponseEntity<>(find,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
	}

}
