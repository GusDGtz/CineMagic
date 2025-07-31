package com.metaphorce.CineMagic.excepciones;

import org.springframework.validation.BindingResult;

public class PeliculaNoEncontradaExcepcion extends RuntimeException {


    // CONSTRUCTOR
    public PeliculaNoEncontradaExcepcion(String message) {
        super(message);
    }

}
