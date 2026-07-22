package com.hospital.personas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.personas.model.Telefono;

public interface TelefonoRepository extends JpaRepository<Telefono, Long>{
    
}