package com.devfam.miag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.devfam.miag.dao.AdminRepository;
import com.devfam.miag.dao.ClientRepository;
import com.devfam.miag.dao.OperationRepository;
import com.devfam.miag.entities.Admin;
import com.devfam.miag.services.ClientService;
import com.devfam.miag.services.ClientServiceImp;
import com.devfam.miag.services.Md5;

@SpringBootApplication
public class ProjetCompteClientApplication {

	public static void main(String[] args) {

		ApplicationContext ctx= SpringApplication.run(ProjetCompteClientApplication.class, args);
		// AdminRepository adminRepo = ctx.getBean(AdminRepository.class);
		// adminRepo.save(new Admin("222", "devfam", "devfamily", "miag", "bows",
		// "mmd@gmail.com"));
		
			}
}

