package com.devfam.miag.services;

import com.devfam.miag.entities.Client;

public interface ClientService {
	
	public boolean updateClient(Client client);
	
	// Recuperation de mot de passe 
	public void resetPassword();

}
