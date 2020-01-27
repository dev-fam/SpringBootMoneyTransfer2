package com.devfam.miag.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.devfam.miag.dao.AdminRepository;
import com.devfam.miag.entities.Admin;
import com.devfam.miag.entities.Client;

public class AdminServiceImp implements AdminService  {

	//declaration du bean Admin repository du DAO pour faire les traitements relative a Admin
	@Autowired
	AdminRepository adminRepo;
	
	
	@Override
	public boolean addClient(Client client) {
		// TODO Auto-generated method stub
		boolean success=false;
		
		return success;
	}

	@Override
	public boolean updateClient() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteClient(Long idClient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean debitAccount(String numCompte) {
		// TODO Auto-generated method stub
		return false;
	}

}
