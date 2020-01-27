package com.devfam.miag.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// on utilise l'interface predifini userdetails pour gerer les comptes

public class AdminSecurityDetails extends Admin implements UserDetails{

	public AdminSecurityDetails(Admin admin) {
		super(admin.getIdAdmin(), admin.getNni(), admin.getLogin(), admin.getPassword(), 
				admin.getNom(), admin.getPrenom(), admin.getEmail());
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
