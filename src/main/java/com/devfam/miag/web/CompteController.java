package com.devfam.miag.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devfam.miag.entities.Compte;
import com.devfam.miag.services.CompteService;

@RestController
@RequestMapping("/compte")
public class CompteController {
	@Autowired
	CompteService compteService;
	
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
	
	@PostMapping("/new")
	public Compte addCompte(@RequestBody Compte compte) {
		return compteService.addCompte(compte);
	}
	
	@PostMapping("/retrait")
	public String faireRetrait(@RequestBody String numCompte, @RequestBody double montant) {
		// TAKE THESE VALUES FROM A FORM THEN USE creditCompte service
		// TEST THIS ONE
		boolean result = compteService.crediteAccount(numCompte, montant);
		if(result == true)
			return "SUCCESS";
		else return "FAILURE";
	}
	
	@PostMapping("/transfer")
	public String send(@RequestBody String numCompteSource, @RequestBody String numCompteDest, @RequestBody double montant) {
		// TAKE THESE VALUES FROM A FORM THEN USE creditCompte service
		// TEST THIS ONE
		boolean result = compteService.sendMoney(numCompteSource, numCompteDest, montant);
		//SUCCESS VS FAILED
		if(result == true)
			return "SUCCESS";
		else return "FAILURE";
	}
}
