package com.devfam.miag.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Operation {
	@Id
	private Long idOperation;
	private String type;
	@Temporal(TemporalType.DATE)
	private Date dateOperation;
	
	@ManyToOne
	private Compte compte;

	public Operation(String type, Date dateOperation, Compte compte) {
		super();
		this.type = type;
		this.dateOperation = dateOperation;
		this.compte = compte;
	}

	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdOperation() {
		return idOperation;
	}

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
	

}
