package com.metaphorce.CineMagic.repositorios;

import com.metaphorce.CineMagic.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombre_usuario);
}
