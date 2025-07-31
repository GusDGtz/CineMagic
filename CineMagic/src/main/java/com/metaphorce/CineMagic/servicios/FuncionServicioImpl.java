package com.metaphorce.CineMagic.servicios;

import com.metaphorce.CineMagic.entidades.Funcion;
import com.metaphorce.CineMagic.repositorios.FuncionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionServicioImpl implements FuncionServicio{

    @Autowired
    FuncionRepositorio repositorio;

    @Override
    public List<Funcion> obtenerFunciones() {
        return repositorio.findAll();
    }

    @Override
    public Funcion modificarFuncion(Integer id_funcion, Funcion funcionModificada) {
        Funcion funcionExistente = repositorio.findById(id_funcion).orElseThrow(() -> new RuntimeException("Funcion no encontrada"));

        funcionExistente.setFecha_funcion(funcionModificada.getFecha_funcion());
        funcionExistente.setHorario_funcion(funcionModificada.getHorario_funcion());
        funcionExistente.setSala(funcionModificada.getSala());
        funcionExistente.setPelicula(funcionModificada.getPelicula() );

        return repositorio.save(funcionExistente);
    }
}
