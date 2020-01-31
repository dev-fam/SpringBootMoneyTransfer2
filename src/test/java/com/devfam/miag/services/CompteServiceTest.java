package com.devfam.miag.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.devfam.miag.dao.CompteRepository;
import com.devfam.miag.entities.Client;
import com.devfam.miag.entities.Compte;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CompteServiceTest {
	
	@Autowired
	private CompteService compteservice;
	
	@MockBean
	private CompteRepository compterepository;
	
	@Test
	public void checkSoldeTest() {
		List<Compte> listeComptes = new ArrayList<>();
		Client client = new Client("12345676", "ismail","123A", "Ba", "Ismail", "email@gmail.com","arafat", "46573849", listeComptes);
		Compte compte = new Compte("10",2000, "courant", client);
		double c= compteservice.checkSolde("10");
		Mockito.when(compterepository.findByNumCompte("10")).thenReturn(compte);
		
		assertFalse(c == compte.getSolde());
	}

}
