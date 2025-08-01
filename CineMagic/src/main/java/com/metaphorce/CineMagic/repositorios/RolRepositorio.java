package com.metaphorce.CineMagic.repositorios;

import com.metaphorce.CineMagic.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {
}
