package it.epicode.esercizi.cinema.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.epicode.esercizi.cinema.login.model.LoginRequest;
import it.epicode.esercizi.cinema.login.model.LoginResponse;
import it.epicode.esercizi.cinema.login.model.SignUpRequest;
import it.epicode.esercizi.cinema.login.model.SignUpResponse;
import it.epicode.esercizi.cinema.repository.RoleRepository;
import it.epicode.esercizi.cinema.repository.UserRepository;
import it.epicode.esercizi.cinema.security.JwtUtil;
import it.epicode.esercizi.cinema.security.UserDetImpl;
import it.epicode.esercizi.cinema.security.model.Role;
import it.epicode.esercizi.cinema.security.model.RoleType;
import it.epicode.esercizi.cinema.security.model.User;

@RestController
@RequestMapping("/api")
public class AuthController {

	@Autowired(required=true)
	@Qualifier("authenticationManagerBean") 
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleRepository roleRepo;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<?> convalidaUser(@RequestBody LoginRequest login) {
		Authentication authentication =this.authenticationManager.
				authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

		authentication.getAuthorities();

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = this.jwtUtil.generateJwtToken(authentication);

		UserDetImpl user = (UserDetImpl) authentication.getPrincipal();
		Set<String> roles = user.getAuthorities().stream().map(role -> role.getAuthority()).collect(Collectors.toSet());

		LoginResponse responseLogin = new LoginResponse();
		responseLogin.setToken(jwt);
		responseLogin.setId(user.getId());
		responseLogin.setExpirationTime(user.getExpirationTime());
		responseLogin.setEmail(user.getEmail());
		responseLogin.setUsername(user.getUsername());
		responseLogin.setRole(roles);

		return ResponseEntity.ok(responseLogin);

	}

	@PostMapping("/signup")
	public ResponseEntity<?> userSign(@RequestBody SignUpRequest userRequest){
		
		if(this.userRepo.existsByUsername(userRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new SignUpResponse("username gia in uso"));
		}
		
		if(this.userRepo.existsByEmail(userRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new SignUpResponse("email gia in uso"));
		}
		
		User user=new User();
		user.setCognome(userRequest.getCognome());
		user.setNome(userRequest.getNome());
		user.setPassword(this.encoder.encode(userRequest.getPassword()));
		user.setEmail(userRequest.getEmail());
		user.setUsername(userRequest.getUsername());
		Set<String> strRoles=userRequest.getRole();
		
		Set<Role> roles=new HashSet<>();
		
			if(strRoles==null) {
				Role userRole=this.roleRepo.findByRoles(RoleType.USER).orElseThrow(()->new RuntimeException("nessun ruolo disponibile"));
				roles.add(userRole);
			}else {
				strRoles.stream().forEach(role->{
					if(role.equalsIgnoreCase("admin")) {
						Role admin=this.roleRepo.findByRoles(RoleType.ADMIN).orElseThrow(()->new RuntimeException("nessun ruolo disponibile"));
						roles.add(admin);		
					}
				
					if(role.equalsIgnoreCase("guest")) {
						Role guest=this.roleRepo.findByRoles(RoleType.GUEST).orElseThrow(()->new RuntimeException("nessun ruolo disponibile"));
						roles.add(guest);
					}
				});
				
			}
			user.setRoles(roles);
			this.userRepo.save(user);
			return ResponseEntity.ok(new SignUpResponse("Credenziali salvate"));	
	
	}

}
