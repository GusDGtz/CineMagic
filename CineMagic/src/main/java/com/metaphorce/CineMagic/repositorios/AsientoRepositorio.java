package com.metaphorce.CineMagic.repositorios;

import com.metaphorce.CineMagic.entidades.Asiento;
import com.metaphorce.CineMagic.entidades.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AsientoRepositorio extends JpaRepository<Asiento, Integer> {
    Optional<Asiento> findByFilaAsientoAndColumnaAsientoAndSala(String fila, Integer columna, Sala sala);

}
