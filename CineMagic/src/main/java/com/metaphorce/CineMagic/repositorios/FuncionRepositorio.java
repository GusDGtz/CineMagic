package com.metaphorce.CineMagic.repositorios;

import com.metaphorce.CineMagic.entidades.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionRepositorio extends JpaRepository<Funcion, Integer> {
}
