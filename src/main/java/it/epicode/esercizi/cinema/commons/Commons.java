package it.epicode.esercizi.cinema.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.esercizi.cinema.repository.RoleRepository;
import it.epicode.esercizi.cinema.security.model.Role;
import it.epicode.esercizi.cinema.security.model.RoleType;
@Component
public class Commons implements CommandLineRunner{
	@Autowired
	RoleRepository roleRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Role admin=new Role();
		admin.setRoles(RoleType.ADMIN);
		this.roleRepo.save(admin);
		
		Role user=new Role();
		user.setRoles(RoleType.USER);
		this.roleRepo.save(user);
		
		Role guest=new Role();
		guest.setRoles(RoleType.GUEST);
		this.roleRepo.save(guest);
		
	}

}
