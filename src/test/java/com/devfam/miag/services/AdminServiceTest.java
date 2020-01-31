package com.devfam.miag.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devfam.miag.dao.AdminRepository;
import com.devfam.miag.entities.Admin;


//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AdminServiceTest {
	@Autowired
	private AdminService adminservice;
	
	@MockBean
	private AdminRepository adminrepository;
	
	 /*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void addAdmin() {
		Admin admin = new Admin();
		admin.setNni("23123441");
		admin.setLogin("Monnlight");
		admin.setPassword("123");
		admin.setNom("BA");
		admin.setPrenom("Ismail");
		admin.setEmail("Isamil@gmail.com");
		
		Mockito.when(adminrepository.save(admin)).thenReturn(admin);
		assertThat(adminservice.addAdmin(admin)).isEqualTo(admin);
	}
	 /*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void  getAllAdmins() {
		Admin admin1 = new Admin();
		admin1.setNni("23123441");
		admin1.setLogin("Monnlight");
		admin1.setPassword("123");
		admin1.setNom("BA");
		admin1.setPrenom("Ismail");
		admin1.setEmail("Isamil@gmail.com");
		
		Admin admin2 = new Admin();
		admin2.setNni("23233441");
		admin2.setLogin("bows");
		admin2.setPassword("123");
		admin2.setNom("BA");
		admin2.setPrenom("Oumar");
		admin2.setEmail("Isamil@gmail.com");
		
		List<Admin> malist = new ArrayList<>();
		malist.add(admin1);
		malist.add(admin2);
		
		Mockito.when(adminrepository.findAll()).thenReturn(malist);
		assertThat(adminservice.getAllAdmins()).isEqualTo(malist);
	}
	 /*..................................................................................................../
    .....................................................................................................*/
	@Test
	public void getAdminById() {
		Admin admin1 = new Admin();
		admin1.setIdAdmin(29L);
		admin1.setNni("23123441");
		admin1.setLogin("Monnlight");
		admin1.setPassword("123");
		admin1.setNom("BA");
		admin1.setPrenom("Ismail");
		admin1.setEmail("Isamil@gmail.com");
		adminservice.addAdmin(admin1);
		//Admin admin2 = adminservice.getAdminById(admin1.getIdAdmin());
		
		Mockito.when(adminrepository.getOne(admin1.getIdAdmin())).thenReturn(admin1); 
		
	}
	

}
