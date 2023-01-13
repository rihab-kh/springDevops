package com.isamm.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isamm.projet.entities.DetailClient;


public interface DetailClientDAO extends JpaRepository<DetailClient, Long> {

}
