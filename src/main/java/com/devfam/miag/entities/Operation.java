package com.devfam.miag.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Operation {
	@Id @GeneratedValue
	private Long idOperation;
	private String type;
	@Temporal(TemporalType.DATE)
	private Date dateOperation;
	private String numCompete;
	private String description;
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(String type, String numCompete, Date dateOperation, String description) {
		super();
		this.type = type;
		this.numCompete = numCompete;
		this.dateOperation = dateOperation;
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumCompete() {
		return numCompete;
	}
	public void setNumCompete(String numCompete) {
		this.numCompete = numCompete;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getIdOperation() {
		return idOperation;
	}
	
	
	}
