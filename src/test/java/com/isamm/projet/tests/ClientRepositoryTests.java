package com.isamm.projet.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.isamm.projet.dao.ClientDAO;
import com.isamm.projet.entities.Client;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClientRepositoryTests {
	
	  @Autowired
	   private ClientDAO clientDAO;
	  
	  @Test
	  @Order(1)
	  @Rollback(false)
	  public void testCreateClient() {
	      Client savedClient = clientDAO.save(new Client("folen", "Manouba", 3));
	       
	      assertThat(savedClient.getIdClient()).isGreaterThan(0);
	  }


	   /* @Test
	    @Order(2)
	    void getListOfClientsTest(){
	    	   List<Client> clients = clientDAO.findAll();
	    	   assertThat(clients).size().isGreaterThan(0);

	    }*/
	  
	    /*@Test
	    @Order(3)
	    @Rollback(value = false)
	    public void updateEmployeeTest(){

	        Client client = clientDAO.findById(1L).get();

	        client.setNbCommande(2);
	        clientDAO.save(client);
	        

	        Client employeeUpdated =  clientDAO.save(client);

	        assertThat(employeeUpdated.getNbCommande()).isEqualTo(2);

	    }

	    @Test
	    @Order(3)
	    @Rollback(value = false)
	    public void deleteClientTest(){

	    	Client client = clientDAO.findById(1L).get();

	    	clientDAO.delete(client);

	        //employeeRepository.deleteById(1L);

	        Client client1 = null;

	        Optional<Client> optionalEmployee = clientDAO.findByNom("folen");

	        if(optionalEmployee.isPresent()){
	        	client1 = optionalEmployee.get();
	        }

	        assertThat(client1).isNull();
	    }*/
}
