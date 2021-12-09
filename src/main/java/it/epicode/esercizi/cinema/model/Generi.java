package it.epicode.esercizi.cinema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="generi")
@NoArgsConstructor
public class Generi {
	@Id
	@SequenceGenerator(name = "generi_sequence",sequenceName = "generi_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="generi_sequence")
	private Long id;
	private String nome;
	private String descrizione;
	

}
