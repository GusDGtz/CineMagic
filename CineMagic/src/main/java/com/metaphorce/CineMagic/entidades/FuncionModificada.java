package com.metaphorce.CineMagic.entidades;

public class FuncionModificada {
    // ATRIBUTOS
    Integer id_funcion;
    String horario;

    // CONSTRUCTORES
    public FuncionModificada(Integer id_funcion, String horario) {
        this.id_funcion = id_funcion;
        this.horario = horario;
    }
    public FuncionModificada() {
    }

    // GET SET
    public Integer getId_funcion() {
        return id_funcion;
    }
    public void setId_funcion(Integer id_funcion) {
        this.id_funcion = id_funcion;
    }
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
