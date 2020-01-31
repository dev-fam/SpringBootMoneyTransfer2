package com.devfam.miag.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devfam.miag.dao.CompteRepository;
import com.devfam.miag.entities.Compte;

@Service
public class CompteServiceImp implements CompteService {
<<<<<<< HEAD

=======
>>>>>>> 5f673aeffaf3208672de520d40504a3291b97583

	// declaration de l'objet CompteRepository pour les traitement avec le DAO
	@Autowired
	CompteRepository compteRepo;

	@Override
	public double checkSolde(String numCompte) {
		// TODO Auto-generated method stub
<<<<<<< HEAD

		Compte compte=compteRepo.findByNumCompte(numCompte);
		
		if(compte == null) {
			return -1;
		}else {
		
			return compte.getSolde() ;}
=======
		Compte compte = compteRepo.findByNumCompte(numCompte);

		if (compte == null) {
			return -1;
		} else {

			return compte.getSolde();
		}
>>>>>>> 5f673aeffaf3208672de520d40504a3291b97583
	}


	@Override
	public boolean sendMoney(String numCompteSource, String numCompteDest, double somme) {
<<<<<<< HEAD

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
=======
		// TODO Auto-generated method stub
		Compte compteSource = compteRepo.findByNumCompte(numCompteSource);
		Compte compteDest = compteRepo.findByNumCompte(numCompteDest);

		if(compteSource != null && compteDest != null) {
			if (compteSource.getSolde() >= somme) {
				compteSource.setSolde(compteSource.getSolde() - somme);
				compteDest.setSolde(compteDest.getSolde() + somme);
				
				//SAVE CHANGES
				compteRepo.save(compteSource);
				compteRepo.save(compteDest);
>>>>>>> 5f673aeffaf3208672de520d40504a3291b97583
				return true;
			} 
		}
		return false;
<<<<<<< HEAD

=======
>>>>>>> 5f673aeffaf3208672de520d40504a3291b97583
	}
	
	@Override
	public boolean crediteAccount(String numCompte, double somme) {
		// Credit comppte code
		double balance = checkSolde(numCompte);
		if (balance != -1) {
			// COMPTE DOES EXIST
			if (balance >= somme) {
				// L'operation est possible car le solde le permet
				Compte compte = compteRepo.findByNumCompte(numCompte);
				compte.setSolde(balance - somme);
				// Retire la somme voulu du complte choisi
				compteRepo.save(compte);

				return true;
				// OPERATION FAIT AVEC SUCCES
			}
		}
		return false;
	}

	public Compte addCompte(Compte compte) {
		Compte newCompte = compteRepo.save(compte);
		if(newCompte != null) {
			newCompte.setDateCreation(new Date());
			compteRepo.save(newCompte);
		}
		return newCompte;
		
	}

	@Override
	public List<Compte> getAllComptes() {
		return compteRepo.findAll();
	}

	public Compte getCompteById(Long id) {
		return compteRepo.findById(id).get();
	}

	@Override
	public Compte getCompteByNumCompte(String numCompte) {
		// TODO Auto-generated method stub
		return compteRepo.findByNumCompte(numCompte);
	}

}
