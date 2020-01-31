package com.devfam.miag.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devfam.miag.entities.Compte;


public interface CompteService{
	
	//La verification d'une compte
	public double checkSolde(String numCompte);
	
	//Transfere d'argent
	public boolean sendMoney(String numCompteSource,String numCompteDest ,double somme);
	
	// Crediter un compte
	public boolean crediteAccount(String numCompte,double somme);

	public List<Compte> getAllComptes();
	
	public Compte getCompteByNumCompte(String numCompte);

	public Compte getCompteById(Long id);

	public Compte addCompte(Compte compte);

}
