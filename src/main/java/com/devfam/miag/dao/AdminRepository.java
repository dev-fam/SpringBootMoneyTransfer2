package com.devfam.miag.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devfam.miag.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
<<<<<<< HEAD

	Optional<Admin> findByLogin(String login);
	Optional<Admin> findByPassword(String password);
	

=======
	Admin findByNni(String nni);
>>>>>>> 11008cfa552a986bf11b915fbce61d32feb3326c
}
