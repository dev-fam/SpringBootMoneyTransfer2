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


	@Override
	public void deleteAdmin(Long idAdmin) {
		Admin admin = adminRepo.findById(idAdmin).get();
		adminRepo.delete(admin);
	}



}
