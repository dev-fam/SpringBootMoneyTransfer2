package com.devfam.miag.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devfam.miag.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByNni(String nni);
}
