package com.devfam.miag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devfam.miag.dao.AdminRepository;
import com.devfam.miag.dao.ClientRepository;
import com.devfam.miag.entities.Admin;
import com.devfam.miag.entities.Client;

@Service //TELL SPRING THIS IS A SERVICE BEAN FOR DEPENDENCE INJECTION
public class AdminServiceImp implements AdminService  {

	//declaration du bean Admin repository du DAO pour faire les traitements relative a Admin
	@Autowired
	ClientRepository clientRepo;
	
	@Autowired
	AdminRepository adminRepo;
	
	
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

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepo.findAll();
	}


	@Override
	public Admin getAdminById(Long id) {
		return adminRepo.findById(id).get();
	}


	@Override
	public Admin addAdmin(Admin admin) {
		return  adminRepo.save(admin);
	}



}
