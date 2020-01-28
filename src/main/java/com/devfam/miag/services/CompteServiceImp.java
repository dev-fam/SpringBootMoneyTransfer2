package com.devfam.miag.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devfam.miag.dao.CompteRepository;
import com.devfam.miag.entities.Compte;
<<<<<<< HEAD

=======
>>>>>>> 88c13543b3efa8e05fa6307cc92926b01fb10e8d


@Service
public class CompteServiceImp implements CompteService {
<<<<<<< HEAD

=======
>>>>>>> 88c13543b3efa8e05fa6307cc92926b01fb10e8d

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
>>>>>>> 88c13543b3efa8e05fa6307cc92926b01fb10e8d
	}

	/*.........................................................................................*/
	/*.........................................................................................*/
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
				return true;
			}
			
		}
		return false;
=======
		// TODO Auto-generated method stub
		Compte compte1 = compteRepo.findByNumCompte(numCompteSource);
		Compte compte2 = compteRepo.findByNumCompte(numCompteDest);
		double b;
		double s = compte2.getSolde();
		if (compte1.getSolde() != 0 && compte1.getSolde() > somme) {
			b = compte1.getSolde() - somme;
			s += b;
			return true;

		} else
			return false;
>>>>>>> 88c13543b3efa8e05fa6307cc92926b01fb10e8d
	}
	/*.........................................................................................*/
	/*.........................................................................................*/
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
