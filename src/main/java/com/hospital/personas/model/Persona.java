package com.hospital.personas.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//una entidad es una tabla 
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; 
    private String apellido; 
    private String email;

    @OneToMany(mappedBy="persona", cascade= CascadeType.ALL, orphanRemoval=true)
    private List<Telefono> telefonos = new ArrayList<>();

    public Persona(){}

    //Getters y setters 
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre; 
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido; 
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email; 
    }

    public List<Telefono> getTelefonos(){
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos){
        this.telefonos = telefonos;
    }
}
