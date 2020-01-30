package com.devfam.miag.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
	private AdminRepository adminRepository;
	
   /*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void testAddAmdin() {
		Admin admin = new Admin("324566737","bowsy","1234","Ba","oumar", "344444@gmail.com");
		adminRepository.save(admin);
		Admin admin1 = adminRepository.findByNni("324566737");
		assertEquals(admin.getNni(), admin1.getNni());
		assertEquals(admin.getPassword(), admin1.getPassword());
	}
	
	/*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void testGetAdmin() {
		Admin admin = new Admin("324566737","bowsy","1234","Ba","oumar", "344444@gmail.com");
		Admin admin1 = new Admin("324566737","bowsy","1234","Ba","oumar", "344444@gmail.com");
		adminRepository.save(admin);
		Admin rs_admin = adminRepository.save(admin1);
		Admin db_admin = adminRepository.getOne(rs_admin.getIdAdmin());
		assertNotNull(db_admin);
	}
	
	/*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void testDeleateAdmin() {
		Admin admin1 = new Admin("324566737","bowsy","1234","Ba","oumar", "344444@gmail.com");
		Admin admin2 = adminRepository.save(admin1);
		adminRepository.delete(admin2);	
	}
	 
	/*..................................................................................................../
    .....................................................................................................*/
	
	@Test
	public void findAllAdminTest() {
		Admin admin1 = new Admin("32456737","bowsy","1234","Ba","oumar", "344444@gmail.com");
		Admin admin3 = new Admin("54543244", "ismail", "324", "Ba","hamidou","HJFSS@yahoo.fr");
		adminRepository.save(admin1);
		adminRepository.save(admin3);
		assertNotNull(adminRepository.findAll());
	}
	
	@Test
	public void updateAdminTest() {
		Admin admin = new Admin("54543244", "ismail", "324", "Ba","hamidou","HJFSS@yahoo.fr");
		Admin admin2 =adminRepository.save(admin);
		
		Admin admin3 = adminRepository.findByNni(admin2.getNni());
		admin3.setNom("Mamadou");
		admin3.setPrenom("Abdourahim");
		admin3.setEmail("Mamadou@gmail.com");
		assertNotNull(admin3);
		adminRepository.save(admin3);
	}
	
}
