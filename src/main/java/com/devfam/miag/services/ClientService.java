package com.devfam.miag.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devfam.miag.entities.Client;

@Service
public interface ClientService {
	
	public boolean updateClient(Client client);
	
	// Recuperation de mot de passe 
	public void resetPassword();

	public List<Client> getAllClients();
	
	//FETCH CLIENT
	public Client  getClient(Long id);
	// CREATE NEW CLIENT
	public Client addClient(Client client);
	
	public boolean deleteClient(Long id);

}
