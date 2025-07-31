package com.metaphorce.CineMagic.servicios;

import com.metaphorce.CineMagic.entidades.Pelicula;
import com.metaphorce.CineMagic.excepciones.PeliculaNoEncontradaExcepcion;
import com.metaphorce.CineMagic.repositorios.PeliculaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServicioImpl implements PeliculaServicio{
    @Autowired
    PeliculaRepositorio repositorio;

    // OBTENER
    @Override
    public List<Pelicula> obtenerPeliculas(){
        List<Pelicula> peliculas;
        peliculas = repositorio.findAll();
        return peliculas;
    }
    @Override
    public Pelicula obtenerPeliculaPorId(Integer id_pelicula){
        Pelicula pelicula;
        pelicula = repositorio.findById(id_pelicula).orElseThrow(()
                -> new PeliculaNoEncontradaExcepcion("Pelicula no encontrada"));
        return pelicula;
    }

}
