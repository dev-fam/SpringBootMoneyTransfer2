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

		Compte compte=compteRepo.findByNumCompte(numCompte);
		
		if(compte == null) {
			return -1;
		}else {
		
			return compte.getSolde() ;}
	}

	/*.........................................................................................*/
	/*.........................................................................................*/
	@Override
	public boolean sendMoney(String numCompteSource, String numCompteDest, double somme) {
		//Envoyer de l'aregent
		
		double balance = checkSolde(numCompteSource);
		if(balance != -1 ) {
			//verication si le compte existe
			Compte compte1 = compteRepo.findByNumCompte(numCompteSource);
			Compte compte2 = compteRepo.findByNumCompte(numCompteDest);
			
			if(compte1.getSolde() != 0 && compte1.getSolde() > somme ) {
				//verification si le solde contient une valeur superieur à somme 
				compte2.setSolde(compte1.getSolde() - somme);
				compteRepo.save(compte2);
				return true;
			}
			
		}
		return false;
	}
	/*.........................................................................................*/
	/*.........................................................................................*/
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
