package com.metaphorce.CineMagic.servicios;

import com.metaphorce.CineMagic.entidades.Usuario;
import com.metaphorce.CineMagic.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
     private UsuarioRepositorio usuarioRepositorio;

    // Este metodo permite buscar un usuario por su Username y regresa un UserDetails
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // La excepción es necesaria, por alguna razón
        Usuario usuario = usuarioRepositorio.findByNombreUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        // BUSCAMOS los permisos o roles de este usuario y los guardamos
        GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol().getNombre_rol());
        // Regresamos un UserDetails mediante su CONSTRUCTOR
            // este pide el [nombre] [constrasenia][coleccion de autoridades o roles]
        return new User(usuario.getUsername(), usuario.getPassword(), List.of(authority));
    }
}
