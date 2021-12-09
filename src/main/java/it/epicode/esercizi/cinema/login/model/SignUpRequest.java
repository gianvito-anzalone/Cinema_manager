package it.epicode.esercizi.cinema.login.model;

import java.util.Set;

import javax.validation.constraints.Email;

import lombok.Data;

@Data
public class SignUpRequest {
	private String username;
	private String password;
	@Email
	private String email;
	private Set<String> role;
	private String nome;
	private String cognome;
	
}
