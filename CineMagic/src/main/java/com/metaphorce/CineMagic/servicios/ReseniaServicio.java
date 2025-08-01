package com.metaphorce.CineMagic.servicios;

import com.metaphorce.CineMagic.entidades.PublicacionResenia;
import com.metaphorce.CineMagic.entidades.Resenia;
import org.springframework.http.ResponseEntity;

public interface ReseniaServicio {
    String crearResenia(PublicacionResenia resenia, Integer id_pelicula);
}
