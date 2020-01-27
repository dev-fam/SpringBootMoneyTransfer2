package com.devfam.miag.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.devfam.miag.dao.AdminRepository;
import com.devfam.miag.dao.ClientRepository;
import com.devfam.miag.entities.Admin;
import com.devfam.miag.entities.Client;

public class AdminServiceImp implements AdminService  {

	//declaration du bean Admin repository du DAO pour faire les traitements relative a Admin
	@Autowired
	ClientRepository clientRepo;
	
	
	@Override
	public boolean addClient(Client client) {
		// TODO Auto-generated method stub
		
		Client cl =clientRepo.save(client);
		if(cl == null)
			return false;
		else return true;
	}


	@Override
	public boolean deleteClient(Long idClient) {
		// TODO Auto-generated method stub
		Optional<Client> client = clientRepo.findById(idClient);
		if(client == null) {
			return false;
		}else {
			clientRepo.delete(client.get());
			return true;
		}
		
	}



}
