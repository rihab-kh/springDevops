package com.isamm.projet.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isamm.projet.entities.Client;
import com.isamm.projet.entities.DetailClient;
import com.isamm.projet.metier.ClientMetier;

@Controller
public class CLientController {
	
	@Autowired
	private ClientMetier clientMetier;

	@RequestMapping("/")
	public String index() {
		return "redirect:/user/clients";
	}

	@RequestMapping("/user/clients")
	public String clients(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size,  @RequestParam(name="sortField", defaultValue = "nom") String sortField, 
			@RequestParam(name="sortDir", defaultValue = "") String sortDir,
			@RequestParam(name = "errorMessage", defaultValue = "") String errorMessage) {
		Page<Client> listeClients = clientMetier.getClientsPageable(page, size, sortField, sortDir);

		model.addAttribute("activePage", page);
		model.addAttribute("size", size);
		int[] taillePagination = IntStream.range(0, listeClients.getTotalPages()).toArray();
		model.addAttribute("taillePagination", taillePagination);
		model.addAttribute("nbPages", listeClients.getTotalPages());
		model.addAttribute("nbElements", listeClients.getTotalElements());
		model.addAttribute("listeClients", listeClients);
	    model.addAttribute("sortField", sortField);
	    model.addAttribute("sortDir", sortDir);
	    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		return "clients";
	}

	@PostMapping("/user/rechercheClient")
	public String rechercheClient(String nom, Model model) {
		Client client = clientMetier.getClientByNom(nom);
		boolean etat = true;
		if (client == null)
			etat = false;
		else {
			List<Client> clients = new ArrayList<Client>();
			clients.add(client);
			model.addAttribute("activePage", 0);
			model.addAttribute("size", 2);
			model.addAttribute("taillePagination", 0);
			model.addAttribute("listeClients", clients);
			model.addAttribute("etat", etat);			
		}
		return "clients";
	}
	@PostMapping("/user/filtreVille")
	public String filtreVille(String ville, Model model) {
		Client client = clientMetier.getClientByVille(ville);
		boolean etat = true;
		if (client == null)
			etat = false;
		else {
			List<Client> clients = new ArrayList<Client>();
			clients.add(client);
			model.addAttribute("activePage", 0);
			model.addAttribute("size", 2);
			model.addAttribute("taillePagination", 0);
			model.addAttribute("listeClients", clients);
			model.addAttribute("etat", etat);			
		}
		return "clients";
	}
	
	@GetMapping("/admin/supprimerClient")
	public String supprimerClient(Long id, Long activePage, Long nbElements, Long size, RedirectAttributes ra) {
		clientMetier.deleteClient(id);
		System.out.println(" ----"+activePage);
		if(activePage>0 && ((nbElements-1)==(size * (activePage))))
			activePage--;
		ra.addAttribute("page", activePage);
		return "redirect:/user/clients";
		
	}
	
	@GetMapping("/admin/modifierClient")
	public String modifierClient(@RequestParam(name="id")Long id, Model model) {
		Client client = clientMetier.getClientById(id);
		model.addAttribute("client",client);
		return "modifierClient";
	}
	
	@PostMapping("/admin/modifierClient")
	public String modifierClient(Client client) {
		clientMetier.saveClient(client);
		return "redirect:/user/clients";
	}
	
	@PostMapping("/admin/ajouterClient")
	public String enregistrerclient(Client c, Model model) {		
			clientMetier.saveClient(c);
			return "redirect:/user/clients";
	}
	@GetMapping("/admin/ajouterClient")
	public String ajoutClient(Model model) {		
			model.addAttribute("client", new Client());	
			return "ajouterClient";
	}
	
	@GetMapping("/admin/detailsClient")
	public String afficherDetailsClient(@RequestParam(name="id")Long id, Model model) {
		Client c = clientMetier.getClientById(id);
		model.addAttribute("dtClient",c);
		return "detailsClient";
	}
	

}
