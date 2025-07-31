package com.metaphorce.CineMagic.repositorios;

import com.metaphorce.CineMagic.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepositorio extends JpaRepository <Pelicula, Integer>{

}
