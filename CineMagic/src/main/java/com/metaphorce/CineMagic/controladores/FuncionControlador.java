package com.metaphorce.CineMagic.controladores;


import com.metaphorce.CineMagic.entidades.Funcion;
import com.metaphorce.CineMagic.servicios.FuncionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CineMagic/funcion")
public class FuncionControlador {

    @Autowired
    FuncionServicio servicio;


    @PreAuthorize( "hasRole('USER')")
    @GetMapping("/cartelera")
    public List<Funcion> obtenerFunciones(){
        return servicio.obtenerFunciones();
    }

    @PreAuthorize( "hasRole('ADMIN')")
    @PostMapping("/modificar")
    public Funcion modificarFuncion(@RequestParam Integer id_funcion,@RequestBody Funcion funcion){
        return servicio.modificarFuncion(id_funcion, funcion);
    }

}
