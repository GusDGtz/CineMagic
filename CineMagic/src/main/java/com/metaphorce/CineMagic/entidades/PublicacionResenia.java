package com.metaphorce.CineMagic.entidades;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;

public class PublicacionResenia {
    // ATRIBUTOS
    @Min(value = 0, message = "El valor minimo es 0 [0-5]")
    @Max(value = 5, message = "El valor maximo es 5 [0-5]")
    Integer valoracion;
    @Length(max = 500, message = "La reseña debe ser menor a 500 caracteres")
    String cuerpo_resenia;
    // CONSTRUCTORES
    public PublicacionResenia() {
    }
    public PublicacionResenia(Integer valoracion, String cuerpo_resenia) {
        this.valoracion = valoracion;
        this.cuerpo_resenia = cuerpo_resenia;
    }
    // GET SET

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public String getCuerpo_resenia() {
        return cuerpo_resenia;
    }

    public void setCuerpo_resenia(String cuerpo_resenia) {
        this.cuerpo_resenia = cuerpo_resenia;
    }
}
