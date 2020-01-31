package com.devfam.miag.services;


import java.util.List;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.stereotype.Service;

import com.devfam.miag.entities.Admin;
import com.devfam.miag.entities.Client;


public interface AdminService  {
	

	
	public Admin addAdmin(Admin admin);
	
	
	// Supression d'un admin
	public void deleteAdmin(Long idAdmin);
	
	public List<Admin> getAllAdmins();


	public Admin getAdminById(Long id);
	
	
	
}
