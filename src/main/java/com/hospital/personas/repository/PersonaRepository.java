package com.hospital.personas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.personas.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{  
}
