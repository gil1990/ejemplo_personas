package com.hospital.personas.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hospital.personas.model.Usuario;
import com.hospital.personas.repository.UsuarioRepository;


@Service
public class UsuarioDetailsService implements UserDetailsService{
    
    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Usuario usuario = usuarioRepository.findByEmail(email)
            .orElseThrow(() ->
                new UsernameNotFoundException("Usuario no encontrado: "+ email));

        return User.builder()
            .username(usuario.getEmail())
            .password(usuario.getPassword())
            .authorities(new SimpleGrantedAuthority("ROLE_"+ usuario.getRol()))
            .build();
    }
}
