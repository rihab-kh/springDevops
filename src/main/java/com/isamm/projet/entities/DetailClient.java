package com.isamm.projet.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.isamm.projet.entities.Client;


@Entity
@Table(name="DETAIL_CLIENT")
public class DetailClient implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "foreigngen")
    @GenericGenerator(strategy = "foreign", name="foreigngen",parameters = @Parameter(name = "property", value="client"))
    @Column(name = "CODE")
	private long code;
	//private String nomClient;
	private String mail;
	private int tel;
	
	
	@OneToOne(mappedBy ="detailClient")
	private Client client;
	
	
	@OneToOne(mappedBy ="detailClient")
	private Adresse adresse;


	public DetailClient() {
	}

	public DetailClient(String mail, int tel) {
		
		this.mail = mail;
		this.tel = tel;
	}



	public long getCode() {
		return code;
	}


	public void setCode(long code) {
		this.code = code;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public int getTel() {
		return tel;
	}


	public void setTel(int tel) {
		this.tel = tel;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	
}
