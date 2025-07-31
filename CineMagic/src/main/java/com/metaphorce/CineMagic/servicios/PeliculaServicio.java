package com.metaphorce.CineMagic.servicios;


import com.metaphorce.CineMagic.entidades.Pelicula;

import java.util.List;

public interface PeliculaServicio {

    //READ ALL
    List<Pelicula> obtenerPeliculas();

    //READ UNO
    Pelicula obtenerPeliculaPorId(Integer id_pelicula);


}
