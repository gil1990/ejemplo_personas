package com.hospital.personas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.hospital.personas.model.Persona;
import com.hospital.personas.repository.PersonaRepository;


@Service
public class PersonaService {
    
    @Autowired
    private PersonaRepository personaRepository;

    //listar personas
    public List<Persona> listarTodas(){
        return personaRepository.findAll();
    }

    //buscar personas
    public Persona obtenerPorId(Long id){
        return personaRepository.findById(id).orElse(null);
    }

    //guardar o actualizar
    public Persona guardar(Persona persona){
        return personaRepository.save(persona);
    }


}
