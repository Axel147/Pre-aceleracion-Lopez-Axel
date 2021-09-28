package com.disney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.model.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje,Long>{

 
}