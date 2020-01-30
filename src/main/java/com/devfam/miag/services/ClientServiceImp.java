package com.devfam.miag.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.devfam.miag.entities.Client;

public class ClientServiceImp implements ClientService{

	@Override
	public boolean updateClient(Client client) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public void resetPassword() {
		// PASSWORD RESET USING SPRING SECURITY 
		
	}

	@Override
	public boolean VerificationPassword(String password,String encodedPwd) {
		// TODO Auto-generated method stub
		
		
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        
	        if(passwordEncoder.matches(password, encodedPwd)){
				return true;}
			else {return false;}
		
		
	}

	@Override
	public String CryptdMdp(String pwd) {
		// TODO Auto-generated method stub
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String crypted= passwordEncoder.encode(pwd);
		return crypted ;
	}

}
