package com.devfam.miag.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devfam.miag.entities.Operation;
import com.devfam.miag.services.OperationService;

@RestController
@RequestMapping("/operation")
@CrossOrigin(origins = "http://localhost:4200")
// THIS IS SO THAT ANGULAR GET INTERACT WITH OUR BACKEND
public class OperationController {
	@Autowired
	OperationService operationService;



	@GetMapping("/all")
	public List<Operation> getOps() {
		return operationService.getAllOperations();
	}

}
