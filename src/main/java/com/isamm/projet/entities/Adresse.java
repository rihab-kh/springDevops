package com.isamm.projet.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ADRESSE")
public class Adresse implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAdresse;
	private int numLocal;
	private String rue;
	private String ville;
	private int codePostal;

	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private DetailClient detailClient;
	
	public Adresse() {
	}

	public Adresse(long idAdresse, int numLocal, String rue, String ville, int codePostal) {
		super();
		this.idAdresse = idAdresse;
		this.numLocal = numLocal;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public long getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(long idAdresse) {
		this.idAdresse = idAdresse;
	}

	public int getNumLocal() {
		return numLocal;
	}

	public void setNumLocal(int numLocal) {
		this.numLocal = numLocal;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public DetailClient getDetailClient() {
		return detailClient;
	}

	public void setDetailClient(DetailClient detailClient) {
		this.detailClient = detailClient;
	}

	
}
