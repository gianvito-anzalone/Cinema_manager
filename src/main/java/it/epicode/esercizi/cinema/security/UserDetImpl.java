package it.epicode.esercizi.cinema.security;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.epicode.esercizi.cinema.security.model.User;
import lombok.Data;

@Data
public class UserDetImpl implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1635312927336343088L;

	private Long id;

	private String username;
	private String email;
	@JsonIgnore
	private String password;

	private boolean accountNonLocked = true;
	private boolean accountNonExpired = false;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	private Date expirationTime;

	private Collection<? extends GrantedAuthority> authorities;

	private UserDetImpl(Long id, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities, Boolean enable) {

		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		
		this.authorities = authorities;
		this.accountNonLocked = enabled;
		this.accountNonExpired = enabled;
		this.credentialsNonExpired = enabled;
		this.enabled = enable;
	}

	public static UserDetImpl build(User user) {
		List<GrantedAuthority> aut = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoles().name())).collect(Collectors.toList());

		return new UserDetImpl(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), aut,
				user.isActive());
	}
}
