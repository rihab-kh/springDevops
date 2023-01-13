package com.isamm.projet.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.isamm.projet.entities.DetailClient;

@Entity
@Table(name="CLIENT")
public class Client implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idClient;
	private String nom;
	private String ville;
	private int nbCommande;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private DetailClient detailClient;
	
	
	public Client() {
	}

	public Client(long idClient, String nom, String ville, int nbCommande) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.ville = ville;
		this.nbCommande = nbCommande;
	}
	public Client(String nom, String ville, int nbCommande) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.nbCommande = nbCommande;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getNbCommande() {
		return nbCommande;
	}

	public void setNbCommande(int nbCommande) {
		this.nbCommande = nbCommande;
	}

	public DetailClient getDetailClient() {
		return detailClient;
	}

	public void setDetailClient(DetailClient detailClient) {
		this.detailClient = detailClient;
	}
	

}
