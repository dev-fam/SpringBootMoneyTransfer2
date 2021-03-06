package com.devfam.miag.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devfam.miag.dao.ClientRepository;
import com.devfam.miag.entities.Client;

@Service
public class ClientServiceImp implements ClientService {
	@Autowired
	ClientRepository repoClient;

	@Override
	public List<Client> getAllClients() {
		return repoClient.findAll();
	}

	@Override
	public Client getClient(Long id) {
		return repoClient.findById(id).get();
	}

	@Override
	public Client addClient(Client client) {
		String password = client.getPassword();
		client.setPassword(CryptdMdp(password));
		// ENCRYPT THE PASSWORD THEN SAVE IT TO DB

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
		if (client == null) {
			return false;
		} else {
			repoClient.delete(client.get());
			return true;
		}

	}

	public boolean VerificationPassword(String password, String encodedPwd) {
		// TODO Auto-generated method stub

		if (password.equals(encodedPwd)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String CryptdMdp(String pwd) {
		// TODO Auto-generated method stub
		/*
		 * BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); String
		 * crypted= passwordEncoder.encode(pwd);
		 */

		Md5 md5 = new Md5(pwd);

	
		return md5.codeGet();

		// REPLACE BY MD5
	}

	@Override
	public boolean login(String login, String pwd) {
		Client client = repoClient.findByLogin(login);

		if (client.getPassword().equals(CryptdMdp(pwd)))
			return true;
		return false;

	}

}
