package com.metaphorce.CineMagic.servicios;


import com.metaphorce.CineMagic.entidades.IngresoUsuario;
import com.metaphorce.CineMagic.entidades.Rol;
import com.metaphorce.CineMagic.entidades.Usuario;
import com.metaphorce.CineMagic.repositorios.RolRepositorio;
import com.metaphorce.CineMagic.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    @Autowired
    RolRepositorio rol_repositorio;
    @Autowired
    UsuarioRepositorio usuario_repositorio;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // REGISTRAR UN USUARIO
    @Override
    public Usuario crearUsuario(Integer id_rol, Usuario usuario) {
        // Le damos el rol
        Rol rol = rol_repositorio.findById(id_rol).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        usuario.setRol(rol);
        // Le cambiamos la constrasenia a una cifrada
        usuario.setContrasenia(passwordEncoder.encode(usuario.getPassword()));

        return usuario_repositorio.save(usuario);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios;
        usuarios = usuario_repositorio.findAll();
        return usuarios;
    }

    @Override
    public Usuario iniciarSesion(IngresoUsuario peticion) {

        Usuario ingresado = usuario_repositorio.findByNombreUsuario(peticion.getNombreUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        boolean valido = passwordEncoder.matches(peticion.getContrasenia(), ingresado.getContrasenia());
        if(!valido){
            throw new RuntimeException("Contrasena incorrecta");
        }
        return ingresado;
    }


}
