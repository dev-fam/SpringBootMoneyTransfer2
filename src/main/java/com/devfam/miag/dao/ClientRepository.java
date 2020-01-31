package com.devfam.miag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.devfam.miag.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {
	Client findByNni(String nni);

	public List<Client>  findByNom(String nom);
	
	public Client  findByLogin(String login);
	
}
