package com.metaphorce.CineMagic.repositorios;

import com.metaphorce.CineMagic.entidades.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoRepositorio extends JpaRepository<Boleto, Integer> {
}
