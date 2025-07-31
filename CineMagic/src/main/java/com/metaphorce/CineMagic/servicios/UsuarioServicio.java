package com.metaphorce.CineMagic.servicios;

import com.metaphorce.CineMagic.entidades.IngresoUsuario;
import com.metaphorce.CineMagic.entidades.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsuarioServicio {

    Usuario crearUsuario(Integer id_rol, Usuario usuario);

    List<Usuario> obtenerUsuarios();

    Usuario iniciarSesion(IngresoUsuario peticion);
}
