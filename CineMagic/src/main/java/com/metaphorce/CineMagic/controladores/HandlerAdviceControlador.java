package com.metaphorce.CineMagic.controladores;


import com.metaphorce.CineMagic.excepciones.PeliculaNoEncontradaExcepcion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HandlerAdviceControlador {

    @ExceptionHandler(PeliculaNoEncontradaExcepcion.class)
    public ResponseEntity<?> peliculaNoEncontrada(PeliculaNoEncontradaExcepcion excepcion){
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Not Found");
        body.put("message", excepcion.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }

}
