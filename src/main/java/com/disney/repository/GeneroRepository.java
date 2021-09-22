package com.disney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long>{

}


