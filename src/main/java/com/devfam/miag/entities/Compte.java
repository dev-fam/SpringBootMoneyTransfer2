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
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(String numCompte, double solde, String type) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateCreation = new Date();
		this.type = type;
	}
	public Long getIdCompte() {
		return idCompte;
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

	

}
