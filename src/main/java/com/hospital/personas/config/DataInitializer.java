package com.hospital.personas.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.hospital.personas.model.Usuario;
import com.hospital.personas.repository.UsuarioRepository;


@Component
public class DataInitializer implements CommandLineRunner {
    
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run (String... args){
        if (usuarioRepository.findByEmail("admin@hospital.com").isEmpty()){
            Usuario admin = new Usuario();
            admin.setNombre("Admin");
            admin.setEmail("admin@hospital.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRol("ADMIN");
            usuarioRepository.save(admin);
        }
        if (usuarioRepository.findByEmail("usuario@hospital.com").isEmpty()){
            Usuario usuario = new Usuario();
            usuario.setNombre("Usuario");
            usuario.setEmail("usuario@hospital.com");
            usuario.setPassword(passwordEncoder.encode("usuario123"));
            usuario.setRol("USUARIO");
            usuarioRepository.save(usuario);
        }
    }
}
