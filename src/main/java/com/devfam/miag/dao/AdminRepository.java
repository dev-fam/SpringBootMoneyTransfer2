package com.devfam.miag.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devfam.miag.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {


	Optional<Admin> findByLogin(String login);
	Optional<Admin> findByPassword(String password);
	
	Admin findByNni(String nni);


}
