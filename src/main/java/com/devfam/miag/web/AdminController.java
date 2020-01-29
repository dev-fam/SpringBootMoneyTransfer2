package com.devfam.miag.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devfam.miag.entities.Admin;
import com.devfam.miag.services.AdminService;

@RestController
@RequestMapping("/admin")

@CrossOrigin(origins = "http://localhost:4200")
// THIS IS SO THAT ANGULAR GET INTERACT WITH OUR BACKEND
public class AdminController {
	@Autowired
	AdminService adminService;



	@PostMapping("/new")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}

	@GetMapping("/all")
	public List<Admin> getComptes() {
		return adminService.getAllAdmins();
	}

	@GetMapping("/{id}")
	public Admin getCompte(@PathVariable Long id) {
		return adminService.getAdminById(id);
	}
	
	@PostMapping("/delete")
	public String deleteClient(@RequestBody Admin admin) {
		adminService.deleteAdmin(admin.getIdAdmin());
		return "Done";
	}
	
	//updateAdmin()
}
