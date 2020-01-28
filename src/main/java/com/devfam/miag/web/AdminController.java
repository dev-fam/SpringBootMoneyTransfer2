package com.devfam.miag.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devfam.miag.entities.Admin;
import com.devfam.miag.entities.Client;
import com.devfam.miag.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;

	@PostMapping("/delete")
	public String deleteClient(@RequestBody Client client) {
		boolean result = adminService.deleteClient(client.getIdClient());
		if (result == true)
			return "SUCCESS";
		else
			return "FAILURE";
	}

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
}
