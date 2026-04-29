package com.metaphorce.CineMagic.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Resenia")
public class Resenia {
    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_resenia;
    @Min(value = 0, message = "El valor minimo es 0 [0-5]")
    @Max(value = 5, message = "El valor maximo es 5 [0-5]")
    Integer valoracion;
    @Length(max = 500, message = "La reseña debe ser menor a 500 caracteres")
    String cuerpo_resenia;
    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    @JsonBackReference
    Pelicula pelicula;

    // CONSTRUCTORES

    public Resenia(Integer id_resenia, Integer valoracion, String cuerpo_resenia, Pelicula pelicula) {
        this.id_resenia = id_resenia;
        this.valoracion = valoracion;
        this.cuerpo_resenia = cuerpo_resenia;
        this.pelicula = pelicula;
    }

    public Resenia() {
    }

    // GET SET
    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Integer getId_resenia() {
        return id_resenia;
    }

    public void setId_resenia(Integer id_resenia) {
        this.id_resenia = id_resenia;
    }

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
