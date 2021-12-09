package it.epicode.esercizi.cinema.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="interpretazione")
@NoArgsConstructor
public class Interpretazione {
	@Id
	@SequenceGenerator(name = "inter_generator",sequenceName ="inter_generator",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="inter_generator")
	private Long id;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private Artista attore;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Film film;
	
	private String nome_personaggio;

}
