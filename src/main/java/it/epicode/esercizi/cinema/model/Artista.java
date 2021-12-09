package it.epicode.esercizi.cinema.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="artista")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class Artista {
	@Id
	@SequenceGenerator(name = "artista_generator",sequenceName ="artista_generator",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="artista_generator")
	private Long id;
	private String nome;
	private String cognome;
	@OneToOne(cascade = CascadeType.MERGE)
	private Stato nazione;
	private Date data_nascita;
	@OneToMany(cascade = CascadeType.MERGE)
	@Column(name="list_film")
	private List<Film> listFilm; 

}
