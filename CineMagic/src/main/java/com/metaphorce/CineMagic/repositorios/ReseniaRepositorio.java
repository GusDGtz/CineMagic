package com.metaphorce.CineMagic.repositorios;

import com.metaphorce.CineMagic.entidades.Resenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReseniaRepositorio extends JpaRepository<Resenia, Integer> {
}
