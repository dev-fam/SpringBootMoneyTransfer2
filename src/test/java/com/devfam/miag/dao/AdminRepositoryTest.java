package com.devfam.miag.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devfam.miag.dao.AdminRepository;
import com.devfam.miag.entities.Admin;
import com.devfam.miag.entities.Client;
import com.devfam.miag.entities.Compte;
import com.devfam.miag.services.AdminService;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class AdminRepositoryTest {
	@Autowired
	private AdminService adminRepository;
	@Autowired
	private TestEntityManager em;

	@Test
	public void addedClientTest() {
		List<Compte> listcompte = new ArrayList<>();
		Client client = new Client("34566222","rox","222","Dia","Mamadou","oumar@gmail.com","5eme","34523725", listcompte);
		Client c = em.persist(client); 
		//Client c1 = adminRepository.findByNni(c);
		
		
		
		
		
		/*
		Admin admin = new Admin(20L,"324566737","bowsy","1234","Ba","oumar", "344444@gmail.com");
		adminrepository.save(admin);
		Admin admin1 = adminrepository.findByNni("324566737");
		assertEquals(admin.getNni(), admin1.getNni());
		assertEquals(admin.getPassword(), admin1.getPassword());*/
	}
		
	
}
