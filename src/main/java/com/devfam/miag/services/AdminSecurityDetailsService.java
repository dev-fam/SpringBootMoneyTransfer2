package com.devfam.miag.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.devfam.miag.dao.AdminRepository;
import com.devfam.miag.entities.Admin;
import com.devfam.miag.entities.AdminSecurityDetails;

public class AdminSecurityDetailsService implements UserDetailsService {
	
	@Autowired
	AdminRepository adminRepo;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// Dans cette methode nous recherchons si l admin existe ou pas
		Optional<Admin> optionaladmins =adminRepo.findByLogin(login);
		//Cas ou on trouve pas de correspondance
		optionaladmins.orElseThrow(()-> new UsernameNotFoundException("Cet administrateur n'existe pas"));
		
		// Cas ou on trouve de correspondance
			AdminSecurityDetails adminDetails= optionaladmins.map(AdminSecurityDetails::new).get();
		
		return null;
	}

}
