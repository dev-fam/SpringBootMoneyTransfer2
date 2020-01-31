package com.devfam.miag.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Code_client", nullable = false)
	@JsonBackReference
	private Client client;
	
	/*
	 * @OneToMany(mappedBy = "compte") List<Operation> operations;
	 */

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(String numCompte, double solde,  String type, Client client) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
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
