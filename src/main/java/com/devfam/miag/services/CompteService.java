package com.devfam.miag.services;

public interface CompteService {
	
	//La verification d'une compte
	public double checkSolde(String numCompte);
	
	//Transfere d'argent
	public boolean sendMoney(double somme);
	
	// Crediter un compte
	public boolean crediteAccount(String numCompte);
	
	//

}
