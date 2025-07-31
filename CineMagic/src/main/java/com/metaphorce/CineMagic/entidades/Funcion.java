package com.metaphorce.CineMagic.entidades;

import jakarta.persistence.*;

@Entity
@Table(name="funcion")
public class Funcion {
    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_funcion;
    private String horario_funcion;
    private String fecha_funcion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sala")
    private Sala sala;


    // CONSTRUCTORES
    public Funcion() {
    }
    public Funcion(Integer id_funcion, String horario_funcion, String fecha_funcion, Pelicula pelicula, Sala sala) {
        this.id_funcion = id_funcion;
        this.horario_funcion = horario_funcion;
        this.fecha_funcion = fecha_funcion;
        this.pelicula = pelicula;
        this.sala = sala;
    }

    // GET- SET
    public Integer getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(Integer id_funcion) {
        this.id_funcion = id_funcion;
    }

    public String getHorario_funcion() {
        return horario_funcion;
    }

    public void setHorario_funcion(String horario_funcion) {
        this.horario_funcion = horario_funcion;
    }

    public String getFecha_funcion() {
        return fecha_funcion;
    }

    public void setFecha_funcion(String fecha_funcion) {
        this.fecha_funcion = fecha_funcion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
