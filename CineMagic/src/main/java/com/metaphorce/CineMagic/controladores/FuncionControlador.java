package com.metaphorce.CineMagic.controladores;


import com.metaphorce.CineMagic.entidades.Funcion;
import com.metaphorce.CineMagic.entidades.FuncionModificada;
import com.metaphorce.CineMagic.servicios.FuncionServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CineMagic/funcion")
public class FuncionControlador {

    @Autowired
    FuncionServicio servicio;


    @GetMapping("/cartelera")
    public List<Funcion> obtenerFunciones(){
        return servicio.obtenerFunciones();
    }

    @PreAuthorize( "hasRole('ADMIN')")
    @PostMapping("/modificar-horario")
    public Funcion modificarFuncion(@RequestBody @Valid FuncionModificada funcion){

        return servicio.modificarFuncion(funcion);
    }

    @GetMapping("/{id}")
    public Funcion obtenerFuncionPorId(@PathVariable Integer id){
        return servicio.obtenerFuncionPorId(id);
    }


}
