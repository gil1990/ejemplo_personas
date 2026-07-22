package com.hospital.personas.service;


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.hospital.personas.model.Persona;
import com.hospital.personas.model.Telefono;
import com.hospital.personas.repository.TelefonoRepository;

@Service
public class TelefonoService {

    @Autowired
    private TelefonoRepository telefonoRepository;

    @Autowired
    private PersonaService personaService;

    //agregar un telefono a una persona que ya existe en el sistema
    public void agregarTelefono(Long personaId, String numero){
        Persona persona = personaService.obtenerPorId(personaId);
        if (persona == null) {
            throw new IllegalArgumentException("Persona no encontrada: " + personaId);
        }
        if (numero == null || numero.isBlank()) {
            return;
        }
        Telefono telefono = new Telefono();
        telefono.setNumero(numero.trim());
        telefono.setPersona(persona);
        telefonoRepository.save(telefono);
    }
    

    //eliminar un telefono 
    public void eliminarTelefono(Long id){
        telefonoRepository.deleteById(id);
    }
}
