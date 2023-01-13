package com.isamm.projet.metier;

import java.util.List;

import org.springframework.data.domain.Page;

import com.isamm.projet.entities.Client;
import com.isamm.projet.entities.DetailClient;


public interface ClientMetier {
	
	public List<Client> getClients();
	public void saveClient(Client c);
	public Client getClientById(long id);
	public Client getClientByNom(String nom);
	public Page<Client> getClientsPageable(int page, int size, String sortField, String sortDirection);
	public void deleteClient(Long id);
	public Client getDetailsClientById(long id);
	public Client getClientByVille(String ville);

}
