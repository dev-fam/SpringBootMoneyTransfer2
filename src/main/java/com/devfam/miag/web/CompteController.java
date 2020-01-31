package com.devfam.miag.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devfam.miag.entities.Compte;
import com.devfam.miag.services.CompteService;

@RestController
@RequestMapping("/compte")
@CrossOrigin(origins = "http://localhost:4200")
//THIS IS SO THAT ANGULAR GET INTERACT WITH OUR BACKEND
public class CompteController {
	@Autowired
	CompteService compteService;
	
	@PostMapping("/new")
	public Compte addCompte(@RequestBody Compte compte) {
		return compteService.addCompte(compte);
	}
	
	@GetMapping("/all")
	public List<Compte> getComptes(){
		return compteService.getAllComptes();
		
	}
	
	@GetMapping("/{id}")
	public Compte getCompte(@PathVariable Long id){
		return compteService.getCompteById(id);
	}
	
	@GetMapping("/{numCompte}")
	public Compte searchCompte(@PathVariable String numCompte){
		return compteService.getCompteByNumCompte(numCompte);
	}
	
	@GetMapping("/balance")
	public double comteBalance(@RequestParam String numCompte){
		// @RequestParam for 
		return  compteService.checkSolde(numCompte);
	}	
	
	
	@GetMapping("/retrait")
	public double faireRetrait(@RequestParam String numCompte, @RequestParam double montant) {
		// TAKE THESE VALUES FROM A FORM THEN USE creditCompte service
		boolean result = compteService.crediteAccount(numCompte, montant);
		if(result == true)
			return montant;
		else return -1;
	}
	
	@GetMapping("/transfer/source/{numCompteSource}/dest/{numCompteDest}/montant/{montant}")
	public double send(@PathVariable String numCompteSource, @PathVariable String numCompteDest, @PathVariable double montant) {
		// TAKE THESE VALUES FROM A FORM THEN USE creditCompte service

		boolean result = compteService.sendMoney(numCompteSource, numCompteDest, montant);
		//SUCCESS VS FAILED
		if(result == true)
			return montant;
		else return -1;
	}
}
