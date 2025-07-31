package com.metaphorce.CineMagic.repositorios;

import com.metaphorce.CineMagic.entidades.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsientoRepositorio extends JpaRepository<Asiento, Integer> {
}
