package com.isamm.projet.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.isamm.projet.dao.ClientDAO;
import com.isamm.projet.dao.DetailClientDAO;
import com.isamm.projet.entities.Client;
import com.isamm.projet.entities.DetailClient;

@Service
public class ClientMetierImpl implements ClientMetier{

	@Autowired
	ClientDAO clientDAO;
	
	@Autowired
	DetailClientDAO detailClientDAO;
	
	@Override
	public List<Client> getClients() {
		return clientDAO.findAll();
	}

	@Override
	public void saveClient(Client c) {
		DetailClient detailClient = c.getDetailClient();
		detailClient.setClient(c);
		detailClientDAO.save(detailClient);
		c.setDetailClient(detailClient);
		clientDAO.save(c);
		
	}

	@Override
	public Client getClientById(long id) {
		Optional<Client> c = clientDAO.findById(id);
		if (c.isPresent())
			return c.get();
		else
			return null;
	}

	@Override
	public Page<Client> getClientsPageable(int page, int size, String sortField, String sortDirection) {
	
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
            Sort.by(sortField).descending();
		PageRequest pr = PageRequest.of(page, size, sort);
		return clientDAO.findAll(pr);
	}

	@Override
	public void deleteClient(Long id) {

		clientDAO.deleteById(id);
		
	}

	@Override
	public Client getClientByNom(String nom) {
		Optional<Client> c = clientDAO.findByNom(nom);
		if (c.isPresent())
			return c.get();
		else
			return null;
	}

	@Override
	public Client getDetailsClientById(long id) {
		Optional<Client> c = clientDAO.findById(id);
		Optional <DetailClient> dc = detailClientDAO.findById(id);
		if (c.isPresent())
			return c.get();
		else
			return null;
	}

	@Override
	public Client getClientByVille(String ville) {
		Optional<Client> c = clientDAO.findByVille(ville);
		if (c.isPresent())
			return c.get();
		else
			return null;
	}

}
