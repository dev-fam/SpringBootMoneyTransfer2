package com.devfam.miag.dao;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devfam.miag.entities.Admin;
import com.devfam.miag.entities.Client;
import com.devfam.miag.entities.Compte;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ClientRepositoryTest {
	@Autowired
	private ClientRepository clientrepository;
	/*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void testAddCLient() {
		List<Compte> listeComptes = new ArrayList<>();
		Client client = new Client("12345676", "ismail","123A", "Ba", "Ismail", "email@gmail.com","arafat", "46573849", listeComptes);
		clientrepository.save(client);
		Client client1 = clientrepository.findByNni(client.getNni());
		assertEquals(client.getAdresse(), client1.getAdresse());
			
	}
	/*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void testGetClient() {
		List<Compte> listeComptes = new ArrayList<>();
		Client clientriche = new Client("12345676", "ismail","123A", "Ba", "Ismail", "email@gmail.com","arafat", "46573849", listeComptes);
		clientrepository.save(clientriche);
		Client clientPauvre = clientrepository.getOne(clientriche.getIdClient());
		assertEquals(clientPauvre.getNom(), clientriche.getNom());
	}
	/*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void testDeleateClient() {
		List<Compte> listeComptes = new ArrayList<>();
		Client clientriche = new Client("12345676", "ismail","123A", "Ba", "Ismail", "email@gmail.com","arafat", "46573849", listeComptes);
		Client aclient_todeleate = clientrepository.save(clientriche);
		clientrepository.delete(aclient_todeleate);
	}
	/*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void findAllClientTest() {
		List<Compte> listeComptes = new ArrayList<>();
		List<Compte> liste = new ArrayList<>();
		Client clientriche = new Client("12345676", "ismail","123A", "Ba", "Ismail", "email@gmail.com","arafat", "46573849", listeComptes);
		Client client = new Client("22345636", "ismail","123A", "Ba", "Ismail", "email@gmail.com","arafat", "46573849", liste);
		clientrepository.save(clientriche);
		clientrepository.save(client);
		assertNotNull(clientrepository.findAll());
	}
	
	@Test
	public void updateClientTest() {
		List<Compte> liste = new ArrayList<>();
		Client clientriche = new Client("12345676", "ismail","123A", "Ba", "Ismail", "email@gmail.com","arafat", "46573849", liste);
		Client c = clientrepository.save(clientriche);
		Client c2 = clientrepository.findByNni(c.getNni());
		c2.setNom("Ndoye");
		c2.setPrenom("Ousmanse");
		c2.setLogin("weuze");
		clientrepository.save(c2);
		assertTrue(c2.getNom() == "Ndoye");
		
	}
	

}
