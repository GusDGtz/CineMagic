package com.metaphorce.CineMagic.entidades;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PeticionAsiento {
    @NotEmpty(message = "El campo fila es obligatorio")
    @NotNull(message = "El campo fila es obligatorio")
    private String fila;
    @NotEmpty(message = "El campo columna es obligatorio")
    @NotNull(message = "El campo columna es obligatorio")
    private Integer columna;

    public PeticionAsiento(String fila, Integer columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public PeticionAsiento() {

    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }
}
