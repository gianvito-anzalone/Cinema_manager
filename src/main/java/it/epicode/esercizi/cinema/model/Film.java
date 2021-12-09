package it.epicode.esercizi.cinema.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="film")
@NoArgsConstructor
public class Film {
	@Id
	@SequenceGenerator(name="film_sequence_be",sequenceName = "film_sequence_be",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "film_sequence_be")
	private Long id;
	
	private String titolo;
	private int anno;
	@Column(columnDefinition = "character(255) ")
	private String lingue;
	@OneToOne(cascade = CascadeType.MERGE)
	private Stato paese_di_produzione;
	
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name = "generi_film",
	joinColumns =@JoinColumn(name="film_id"),inverseJoinColumns=@JoinColumn(name="genere_id"))
	private Set<Generi> genere; 
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Artista regista; 
	
	@OneToMany(cascade=CascadeType.MERGE) 
	private List<Interpretazione> interpreti;


}
