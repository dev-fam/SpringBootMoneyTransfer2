package com.devfam.miag.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.devfam.miag.entities.Admin;
import com.devfam.miag.entities.Client;


public interface AdminService  {
	
	// Ajouter d'un client
	public boolean addClient(Client client);
	
	public Admin addAdmin(Admin admin);
	
	
	// Supression d'un client
	public boolean deleteClient(Long idClient);
	
	public List<Admin> getAllAdmins();


	public Admin getAdminById(Long id);
	
}
