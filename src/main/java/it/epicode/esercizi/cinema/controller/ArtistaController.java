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

import it.epicode.esercizi.cinema.model.Artista;
import it.epicode.esercizi.cinema.service.ArtistaService;

@RestController
@RequestMapping("/apiArtista")

public class ArtistaController {

	@Autowired
	ArtistaService serviceArt;


	@PostMapping("/saveArt")
	public void saveArt(@RequestBody Artista art){
		this.serviceArt.saveArt(art);
	}
	

	@GetMapping("/deleteArtista")
	public void deleteArt(@RequestParam long id) {
		this.serviceArt.deleteArt(id);
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll(Pageable page){
		Page<Optional<Artista>> find=this.serviceArt.findAll(page);
		if(find.hasContent())
			return new ResponseEntity<>(find,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
	
	}

	@GetMapping("/getbyid")
	public ResponseEntity<?> getById(@RequestParam long id){
		Artista art=this.serviceArt.findbyId(id);
		if(art!=null)
			return new ResponseEntity<>(art,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
	}


}
