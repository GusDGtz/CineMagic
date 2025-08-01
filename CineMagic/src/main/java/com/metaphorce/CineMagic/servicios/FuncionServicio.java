package com.metaphorce.CineMagic.servicios;

import com.metaphorce.CineMagic.entidades.Funcion;
import com.metaphorce.CineMagic.entidades.FuncionModificada;

import java.util.List;

public interface FuncionServicio {

    // VER TODAS LAS FUNCIONES
    List<Funcion> obtenerFunciones();
    // VER UNA FUNCION
    Funcion obtenerFuncionPorId(Integer id_funcion);

    // MODIFICAR FUNCION
    Funcion modificarFuncion(FuncionModificada funcionModificada);

}
