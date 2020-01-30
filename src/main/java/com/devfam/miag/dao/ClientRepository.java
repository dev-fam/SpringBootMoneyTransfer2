package com.devfam.miag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.devfam.miag.entities.Client;


<<<<<<< HEAD
public interface ClientRepository extends JpaRepository<Client, Long> {
	Client findByNni(String nni);
=======
	public List<Client>  findByNom(String nom);
	
>>>>>>> 3852ea356f1acc324a35f7fae1a71c3f745a19eb
}
