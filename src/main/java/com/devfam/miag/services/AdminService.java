package com.devfam.miag.services;

import com.devfam.miag.entities.Client;

public interface AdminService {
	
	// Ajouter d'un client
	public boolean addClient(Client client);
	
	
	// Supression d'un client
	public boolean deleteClient(Long idClient);
	
	

}
