package com.devfam.miag.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devfam.miag.dao.OperationRepository;
import com.devfam.miag.entities.Admin;
import com.devfam.miag.entities.Operation;

@Service
public class OperationServiceImpl implements OperationService {
	@Autowired
	OperationRepository operationRepo;

	@Override
	public List<Operation> getAllOperations() {
		// TODO Auto-generated method stub
		return operationRepo.findAll();
	}




}
