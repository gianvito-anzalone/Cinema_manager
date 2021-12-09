package it.epicode.esercizi.cinema.security.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "role")
public class Role {

	@Id
	@SequenceGenerator(name="role_ge",sequenceName = "role_ge",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="role_ge")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private RoleType roles;
}
