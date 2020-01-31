package com.devfam.miag.dao;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devfam.miag.entities.Client;
import com.devfam.miag.entities.Compte;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CompteRepositoryTest {
	@Autowired
	private CompteRepository compterepository;
	/*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void testAddCompte() {
		List<Compte> listeComptes = new ArrayList<>();
		Client client = new Client("12345676", "ismail","123A", "Ba", "Ismail", "email@gmail.com","arafat", "46573849", listeComptes);
		Compte compte = new Compte("10",2000, "courant", client);
		compterepository.save(compte);
		Compte compte1 = compterepository.findByNumCompte(compte.getNumCompte());
		assertEquals(compte1.getClient(), compte.getClient());
	}
	/*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void testGetCompte() {
		List<Compte> listeComptes = new ArrayList<>();
		Client client = new Client("12345676", "ismail","123A", "Ba", "Ismail", "email@gmail.com","arafat", "46573849", listeComptes);
		Compte compte = new Compte("10",2000, "courant", client);
		compterepository.save(compte);
		Compte compte1 = compterepository.findByNumCompte(compte.getNumCompte());
		assertNotNull(compte1);
	}
	/*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void testDeleateCompte() {
		List<Compte> listeComptes = new ArrayList<>();
		Client client = new Client("12345676", "ismail","123A", "Ba", "Ismail", "email@gmail.com","arafat", "46573849", listeComptes);
		Compte compte = new Compte("10",2000, "courant", client);
		Compte compte1 = compterepository.save(compte);
		compterepository.delete(compte1);
	}
	/*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void findAllCompteTest() {
		List<Compte> listeComptes = new ArrayList<>();
		Client client = new Client("12345676", "ismail","123A", "Ba", "Ismail", "email@gmail.com","arafat", "46573849", listeComptes);
		Compte compte = new Compte("10",2000, "courant", client);
		compterepository.save(compte);
		assertNotNull(compterepository.findAll());
	}
	/*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void updateAdminTest() {
		List<Compte> listeComptes = new ArrayList<>();
		Client client = new Client("12345676", "ismail","123A", "Ba", "Ismail", "email@gmail.com","arafat", "46573849", listeComptes);
		Compte compte = new Compte("10",2000, "courant", client);
		compterepository.save(compte);
		Compte compte2 = compterepository.findByNumCompte(compte.getNumCompte());
		compte2.setSolde(1230);
		compte2.setType("epargne");
		Compte c = compterepository.save(compte2);
		assertTrue(c.getType() == "epargne");
	}
	
}
