package com.devfam.miag.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	private String code;


	public MD5(String code) {
		super();
		this.code = code;
		
		password(code);
	}

	public String getCode() {
		return code;
	}

	
	public void password(String pass) {
		byte passByte[] = pass.getBytes();
		
		try {
			MessageDigest algo = MessageDigest.getInstance("MD5");
			
			algo.reset();
			algo.update(passByte);
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte messageDigest [] = md.digest(passByte);
			
			BigInteger number = new BigInteger(1, messageDigest);
			this.code = number.toString(16);
 		}
		catch(NoSuchAlgorithmException e){
			throw new Error("Invalid Algo", e);
		}
	}
	

}
