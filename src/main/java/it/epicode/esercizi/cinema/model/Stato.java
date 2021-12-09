package it.epicode.esercizi.cinema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="stato")
public class Stato {

	@Id
	@SequenceGenerator(name = "stat_se",sequenceName = "stat_se",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "stat_se")
	private Long id;
	private String nome;
	private String descrizione;
	private String sigla;

}
