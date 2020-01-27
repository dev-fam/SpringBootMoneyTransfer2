package com.devfam.miag.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.devfam.miag.dao.CompteRepository;
import com.devfam.miag.entities.Compte;

public class CompteServiceImp implements CompteService{
	
	// declaration de l'objet CompteRepository pour les traitement avec le DAO
	@Autowired
	CompteRepository compteRepo;

	@Override
	public double checkSolde(String numCompte) {
		// TODO Auto-generated method stub
		Compte compte=compteRepo.findByNumCompte(numCompte);
		
		if(compte == null) {
			return -1;
		}else {
		
			return compte.getSolde() ;}
	}

	@Override
	public boolean sendMoney(String numCompteSource, String numCompteDest, double somme) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crediteAccount(String numCompte, double somme) {
		// TODO Auto-generated method stub
		return false;
	}

}
