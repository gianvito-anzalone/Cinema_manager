package it.epicode.esercizi.cinema.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.epicode.esercizi.cinema.repository.UserRepository;
import it.epicode.esercizi.cinema.security.UserDetImpl;
import it.epicode.esercizi.cinema.security.model.User;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepo;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user=this.userRepo.findByUsername(username);
			if(user.isPresent())
				return  UserDetImpl.build(user.get());
			else
				throw new UsernameNotFoundException("Username not found"+username);

	}

}
