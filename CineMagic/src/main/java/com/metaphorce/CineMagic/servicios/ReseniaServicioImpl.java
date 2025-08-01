package com.metaphorce.CineMagic.servicios;


import com.metaphorce.CineMagic.entidades.Pelicula;
import com.metaphorce.CineMagic.entidades.PublicacionResenia;
import com.metaphorce.CineMagic.entidades.Resenia;
import com.metaphorce.CineMagic.repositorios.PeliculaRepositorio;
import com.metaphorce.CineMagic.repositorios.ReseniaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReseniaServicioImpl implements ReseniaServicio{

    @Autowired
    ReseniaRepositorio reseniaRepositorio;
    @Autowired
    PeliculaRepositorio peliculaRepositorio;

    @Override
    public String crearResenia(PublicacionResenia publicacion, Integer id_pelicula) {
        Pelicula peliculaCalificada;

        peliculaCalificada = peliculaRepositorio.findById(id_pelicula).orElseThrow(()->new RuntimeException("Pelicula no encontrada"));

        Resenia reseniaCalificada = new Resenia();
        reseniaCalificada.setPelicula(peliculaCalificada);
        reseniaCalificada.setCuerpo_resenia(publicacion.getCuerpo_resenia());
        reseniaCalificada.setValoracion(publicacion.getValoracion());

        reseniaRepositorio.save(reseniaCalificada);

        return "Reseña creada con exito, valoracion: " + publicacion.getValoracion() + "/5";
    }
}
