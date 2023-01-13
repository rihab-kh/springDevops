package com.isamm.projet.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.isamm.projet.entities.Client;

public interface ClientDAO  extends JpaRepository<Client, Long>{
	
	@Query(value = "SELECT * FROM CLIENT where nom like %:nom%",nativeQuery = true)
	Optional<Client> findByNom(String nom);
	
	@Query(value = "SELECT ville FROM CLIENT where ville like :x",nativeQuery = true)
	Optional<Client> findByVille(@Param("x") String ville);

}
