package com.hospital.personas.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 

import com.hospital.personas.model.Persona;
import com.hospital.personas.service.PersonaService; 

@Controller
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    //leer personas
    @GetMapping("/")
    public String listarPersonas(Model model){
        model.addAttribute("personas", personaService.listarTodas());
        return "lista";
    }

    //formulario para insertar personas 
    @GetMapping("/nueva")
    public String mostrarFormulario(Model model){
        model.addAttribute("persona", new Persona());
        return "formulario";
    }

    //Editar
    @GetMapping("/editar/{id}")
    public String editarPersona(@PathVariable Long id, Model model){
        model.addAttribute("persona", personaService.obtenerPorId(id));
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarPersona(@ModelAttribute Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }
    
}
