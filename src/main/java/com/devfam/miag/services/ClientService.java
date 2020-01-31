package com.devfam.miag.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devfam.miag.entities.Client;

public interface ClientService {
	
	public boolean updateClient(Client client);
	
	// Recuperation de mot de passe 
	public void resetPassword();
	
	
	//Hachage e mot de passe
	public String CryptdMdp(String pwd);
	
	//Verification de nmot de passe
	public boolean VerificationPassword(String password,String encodedPwd);

	public List<Client> getAllClients();
	
	//FETCH CLIENT
	public Client  getClient(Long id);
	// CREATE NEW CLIENT
	public Client addClient(Client client);
	
	public boolean deleteClient(Long id);
	
	public boolean login(String login, String pwd);


}
