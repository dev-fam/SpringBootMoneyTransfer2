package com.devfam.miag.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Compte implements Serializable {
	@Id
	@GeneratedValue
	private Long idCompte;
	@Column(unique = true)
	private String numCompte;
	private double solde;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private String type;
	
	@ManyToOne
	@JoinColumn(name="Code_client")
	private Client client;

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(Long idCompte, String numCompte, double solde, Date dateCreation, String type, Client client) {
		super();
		this.idCompte = idCompte;
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.type = type;
		this.client = client;
	}

	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Client getClient() {
		return client;
	}
	
	}
