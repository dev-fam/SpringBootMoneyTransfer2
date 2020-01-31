package com.devfam.miag.services;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devfam.miag.dao.ClientRepository;
import com.devfam.miag.entities.Client;

@Service
public class ClientServiceImp implements ClientService {
	@Autowired
	ClientRepository repoClient;
	
	@Override
	public List<Client> getAllClients(){
		return repoClient.findAll();
	}
	
	@Override
	public Client getClient(Long id){
		return repoClient.findById(id).get();
	}
	
	@Override
	public Client addClient(Client client){
		Client newClient = repoClient.save(client);
		return newClient;
	}
	
	

	@Override
	public boolean updateClient(Client newClient) {
		Optional<Client> client = repoClient.findById(newClient.getIdClient());
		// GET THE CLIENT IF EXISTS
		if (client != null) {
			Client old_client = client.get();
			// CASE THE RESULT TO CLIENT
			
			old_client.setAdresse(newClient.getAdresse());
			old_client.setEmail(newClient.getEmail());
			old_client.setNni(newClient.getNni());
			old_client.setLogin(newClient.getLogin());
			old_client.setNom(newClient.getNom());
			old_client.setPrenom(newClient.getPrenom());
			old_client.setTelephone(newClient.getTelephone());
			// SET THE NEW VALUES
			repoClient.save(old_client);
			// SAVE THE NEW VALUES THEN RETURN A SUCCESS MESSAGE
			return true;
		}
		return false;
	}

	@Override
	public void resetPassword() {
		// PASSWORD RESET USING SPRING SECURITY

	}

	@Override
	public boolean deleteClient(Long idClient) {
		// TODO Auto-generated method stub
		Optional<Client> client = repoClient.findById(idClient);
		if(client == null) {
			return false;
		}else {
			repoClient.delete(client.get());
			return true;
		}
		
	}

	public boolean VerificationPassword(String password,String encodedPwd) {
		// TODO Auto-generated method stub
	return true;
		
		
	}

	@Override
	public String CryptdMdp(String pwd) {
		// TODO Auto-generated method stub
		Md5 cod=new Md5(pwd);
		return cod.codeGet();
		
		
	}

}
