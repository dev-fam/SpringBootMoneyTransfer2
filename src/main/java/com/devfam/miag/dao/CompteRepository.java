package com.devfam.miag.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devfam.miag.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	
	//Recherche d'un compte par numero de compte
	public Compte findByNumCompte(String numCompte);
	

}
