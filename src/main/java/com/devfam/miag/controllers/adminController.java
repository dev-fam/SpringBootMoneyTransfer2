package com.devfam.miag.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devfam.miag.dao.AdminRepository;
import com.devfam.miag.dao.ClientRepository;
import com.devfam.miag.entities.Admin;
import com.devfam.miag.entities.Client;
@RestController
public class adminController {
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	ClientRepository clientRepo;
	
	@GetMapping(value = "/search")
	public List<Admin> search(){
		return adminRepo.findAll();
	}
	@PreAuthorize("ETUDIANT")
	@GetMapping(value = "/find/")
	public List<Client> find(){
		return clientRepo.findAll();
	}
}
