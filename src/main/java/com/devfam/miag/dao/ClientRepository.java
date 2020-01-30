package com.devfam.miag.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.devfam.miag.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {
	Client findByNni(String nni);
}
