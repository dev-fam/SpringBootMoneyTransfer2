package com.devfam.miag.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	

	private final Logger LOGGER = LoggerFactory.getLogger(CompteController.class);

/*	@PostMapping("/new")
	public Compte addCompte(@RequestBody Compte compte) {
		return compteService.addCompte(compte);
	}*/

	
	@GetMapping("/all")
	public List<Compte> getComptes(){
		LOGGER.debug("Impossible de retirer de l'argent Le compte est vide ou Verifier les informations saisies");
		
		return compteService.getAllComptes();
		
	}
	
	@GetMapping("/{id}")
	public Compte getCompte(@PathVariable Long id){
		LOGGER.debug("Veuillez entrer en parametre un numero de compte ");
		return compteService.getCompteById(id);
	}
	
	@GetMapping("/{numCompte}")
	public Compte searchCompte(@PathVariable String numCompte){
		LOGGER.debug("Passer votre numero de compte pour que l'url fonctionne");
		return compteService.getCompteByNumCompte(numCompte);
	}
	

	@PostMapping("/new")
	public Compte addCompte(@RequestBody Compte compte) {
		LOGGER.debug("Il faut passer les donnees concernant le compte a ajouter");
		return compteService.addCompte(compte);
	}
	
	/*@PostMapping("/retrait")
	public String faireRetrait(@RequestBody String numCompte, @RequestBody double montant) {
		LOGGER.debug("Impossible de retirer de l'argent Le compte est vide ou Verifier les informations saisies");

	@GetMapping("/balance")
	public double comteBalance(@RequestParam String numCompte){
		// @RequestParam for 
		return  compteService.checkSolde(numCompte);
	}	*/
	
	
	@GetMapping("/retrait")
	public String faireRetrait(@RequestParam String numCompte, @RequestParam double montant) {

		// TAKE THESE VALUES FROM A FORM THEN USE creditCompte service
		boolean result = compteService.crediteAccount(numCompte, montant);

		if(result == true) {
			return "SUCCESS";}
		else {
			LOGGER.debug("Impossible de retirer de l'argent Le compte est vide ou Verifier les informations saisies");
			return "FAILURE";
		}


	}
	
	@PostMapping("/transfer/source/{numCompteSource}/dest/{numCompteDest}/montant/{montant}")
	public String send(@PathVariable String numCompteSource, @PathVariable String numCompteDest, @PathVariable double montant) {
		// TAKE THESE VALUES FROM A FORM THEN USE creditCompte service
		// TEST THIS ONE
		LOGGER.debug("L'envoi vers un autre compte necessite de renseigner les parametres ci dessus compte source,destinataire et le montant");
		
		boolean result = compteService.sendMoney(numCompteSource, numCompteDest, montant);
		//SUCCESS VS FAILED
		if(result == true) {
			return "SUCCESS";
			}
		else {
			
			LOGGER.debug("Impossible d'Envoyer de l'argent Verifier le compte ou les informations Passées");
			return "FAILURE";
		}
		}

	
}
