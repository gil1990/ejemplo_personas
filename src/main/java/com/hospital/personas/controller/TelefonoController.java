package com.hospital.personas.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.personas.service.TelefonoService;


@Controller
public class TelefonoController {

    @Autowired
    private TelefonoService telefonoService;

    @PostMapping("/telefono/agregar/{personaId}")
    public String agregar(@PathVariable Long personaId, @RequestParam String numero ){
        telefonoService.agregarTelefono(personaId, numero);
        return "redirect:/editar/" + personaId;
    }


    @PostMapping("/telefono/eliminar/{id}/{personaId}")
    public String agregar(@PathVariable Long id, @PathVariable Long personaId ){
        telefonoService.eliminarTelefono(id);
        return "redirect:/editar/" + personaId;
    }

    
    
}
