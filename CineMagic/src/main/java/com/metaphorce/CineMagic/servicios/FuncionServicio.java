package com.metaphorce.CineMagic.servicios;

import com.metaphorce.CineMagic.entidades.Funcion;

import java.util.List;

public interface FuncionServicio {

    // VER TODAS LAS FUNCIONES
    List<Funcion> obtenerFunciones();
    // MODIFICAR FUNCION
    Funcion modificarFuncion(Integer id_funcion, Funcion funcion);

}
