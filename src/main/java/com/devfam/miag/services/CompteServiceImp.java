package com.devfam.miag.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devfam.miag.dao.CompteRepository;
import com.devfam.miag.dao.OperationRepository;
import com.devfam.miag.entities.Compte;
import com.devfam.miag.entities.Operation;

@Service
public class CompteServiceImp implements CompteService {

	// declaration de l'objet CompteRepository pour les traitement avec le DAO
	@Autowired
	CompteRepository compteRepo;

	@Autowired
	OperationRepository operationRepo;

	@Override
	public double checkSolde(String numCompte) {
		// TODO Auto-generated method stub

		Compte compte = compteRepo.findByNumCompte(numCompte);

		if (compte == null) {
			return -1;
		} else {

			return compte.getSolde();
		}

	}

	@Override
	public boolean sendMoney(String numCompteSource, String numCompteDest, double somme) {
		// TODO Auto-generated method stub
		Compte compteSource = compteRepo.findByNumCompte(numCompteSource);
		Compte compteDest = compteRepo.findByNumCompte(numCompteDest);

		if (compteSource != null && compteDest != null) {
			if (compteSource.getSolde() >= somme) {
				compteSource.setSolde(compteSource.getSolde() - somme);
				compteDest.setSolde(compteDest.getSolde() + somme);

				// SAVE CHANGES
				compteRepo.save(compteSource);
				compteRepo.save(compteDest);

				// RECORD THE OPERATION
				operationRepo.save(new Operation("Transfert", "", new Date(),
						"Transfert de " + somme + ":From " + numCompteSource + " to " + numCompteDest));

				return true;
			}

			
		}
		return false;
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

				// RECORD THE OPERATION
				operationRepo.save(new Operation("Retrait", numCompte, new Date(), "Retrait de " + somme));

				return true;
				// OPERATION FAIT AVEC SUCCES
			}
		}
		return false;
	}

	public Compte addCompte(Compte compte) {
		Compte newCompte = compteRepo.save(compte);
		if (newCompte != null) {
			newCompte.setDateCreation(new Date());
			compteRepo.save(newCompte);

			// RECORD THE OPERATION
			operationRepo
					.save(new Operation("CreationCompte", compte.getNumCompte(), new Date(), "Creation de Compte"));

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
