package com.devfam.miag;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.devfam.miag.dao.AdminRepository;
import com.devfam.miag.dao.ClientRepository;
import com.devfam.miag.dao.OperationRepository;
import com.devfam.miag.entities.Admin;
import com.devfam.miag.services.ClientService;
import com.devfam.miag.services.ClientServiceImp;

@SpringBootApplication
public class ProjetCompteClientApplication {

	public static void main(String[] args) {
		 SpringApplication.run(ProjetCompteClientApplication.class, args);
		
		
		
		
		
	}

}
