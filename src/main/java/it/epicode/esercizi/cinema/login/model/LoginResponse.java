package it.epicode.esercizi.cinema.login.model;

import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

	
	public LoginResponse() {}
	private String token;
	private final String type="Bearer";
	
	private Long id;
	private String username;
	private String email;
	private Set<String> role; 
	private Date expirationTime;
	

}
