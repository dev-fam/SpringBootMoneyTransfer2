package com.devfam.miag.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.devfam.miag.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
	

}
