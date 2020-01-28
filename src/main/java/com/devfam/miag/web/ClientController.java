package com.devfam.miag.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devfam.miag.dao.ClientRepository;
import com.devfam.miag.entities.Client;
import com.devfam.miag.services.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	//FOR TESTS ONLY
	@Autowired
	ClientService clientService;
	
	@Autowired
	ClientRepository clientRepo;
	
	@GetMapping("/all")
	public List<Client> getClients(){
		return clientService.getAllClients();
		
	}
	
	@GetMapping("/{id}")
	public Client getClients(@PathVariable Long id){
		return clientService.getClient(id);
		
	}
	
	@PostMapping("/new")
	public Client addClient(@RequestBody Client client) {
		Client newClient = clientService.addClient(client);
		return newClient;
	}
	
	@PostMapping("/update")
	public Client updateClient(@RequestBody Client client) {
		clientService.updateClient(client);
		return clientService.getClient(client.getIdClient());
	}

}
