package com.devfam.miag.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.devfam.miag.dao.CompteRepository;
import com.devfam.miag.entities.Compte;

public class CompteServiceImp implements CompteService {

	// declaration de l'objet CompteRepository pour les traitement avec le DAO
	@Autowired
	CompteRepository compteRepo;

	@Override
	public double checkSolde(String numCompte) {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public boolean sendMoney(String numCompteSource, String numCompteDest, double somme) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crediteAccount(String numCompte, double somme) {
		//Credit comppte code
		double balance = checkSolde(numCompte);
		if(balance != -1 ) {
			// COMPTE DOES EXIST
			if(balance >= somme) {
				//L'operation est possible car le solde le permet
				Compte compte =  compteRepo.findByNumCompte(numCompte);
				compte.setSolde(compte.getSolde() - somme);
				//Retire la somme voulu du complte choisi
				compteRepo.save(compte);
				
				return true;
				//OPERATION FAIT AVEC SUCCES
			}
		}
		return false;
	}

}
