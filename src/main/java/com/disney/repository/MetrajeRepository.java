package com.disney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.dto.MetrajeDTO;
import com.disney.model.Metraje;

@Repository
public interface MetrajeRepository extends JpaRepository<Metraje,Long>{

	//para acceder a los metodos crud
	
}