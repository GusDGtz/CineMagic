package com.metaphorce.CineMagic.controladores;

import com.metaphorce.CineMagic.entidades.Pelicula;
import com.metaphorce.CineMagic.servicios.PeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/CineMagic")
public class PeliculaControlador {

    @Autowired
    PeliculaServicio servicio;

    // @Accion ('/ruta')
    @GetMapping("/publico/peliculas")
    public List<Pelicula> obtenerPeliculas(){

        return servicio.obtenerPeliculas();
    }

    @GetMapping("/publico/peliculas/{id}")
    public Pelicula obtenerPeliculaPorId(@PathVariable Integer id){

        return servicio.obtenerPeliculaPorId(id);
    }
}
