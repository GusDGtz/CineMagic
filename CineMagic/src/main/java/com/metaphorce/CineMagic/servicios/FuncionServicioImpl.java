package com.metaphorce.CineMagic.servicios;

import com.metaphorce.CineMagic.entidades.Funcion;
import com.metaphorce.CineMagic.entidades.FuncionModificada;
import com.metaphorce.CineMagic.excepciones.FuncionNoEncontradaException;
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
    public Funcion obtenerFuncionPorId(Integer id_funcion) {

        return repositorio.findById(id_funcion).orElseThrow(()
                -> new FuncionNoEncontradaException("Funcion no encontrada con id: " + id_funcion));
    }

    @Override
    public Funcion modificarFuncion(FuncionModificada funcionModificada) {
        Integer id_funcion = funcionModificada.getId_funcion();

        Funcion funcionExistente = repositorio.findById(id_funcion).orElseThrow(()
                -> new FuncionNoEncontradaException("Funcion no encontrada con id: " + id_funcion + " para modificar"));

        funcionExistente.setHorario_funcion(funcionModificada.getHorario());

        return repositorio.save(funcionExistente);
    }
}
