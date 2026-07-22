package com.hospital.personas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Telefono {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id; 

    private String numero;

    @ManyToOne
    @JoinColumn(name= "persona_id")
    private Persona persona;

    public Telefono() {}

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getNumero(){
        return numero;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }

    public Persona getPersona(){
        return persona;
    }

    public void setPersona(Persona persona){
        this.persona = persona;
    }
   
    
}
