package it.epicode.esercizi.cinema.security.model;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name="user")
@Entity

public class User {

	@Id
	@SequenceGenerator(name = "user_ge",sequenceName = "user_ge",allocationSize = 1)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator="user_ge")
	private Long id;
	
	@Column(nullable = false,unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Email
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = false)
    private String nome;
	@Column(nullable = false)
    private String cognome;
    
    private boolean active=true;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "user_role",joinColumns = @JoinColumn(name="user_id"),
	inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;
    
	public User(String userName, String password, @Email String email, String nome, String cognome) {
		
		this.username = userName;
		this.password = password;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
	}
    
    

}

