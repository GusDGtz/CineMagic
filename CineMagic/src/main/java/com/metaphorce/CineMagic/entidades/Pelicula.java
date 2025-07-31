package com.metaphorce.CineMagic.entidades;


import jakarta.persistence.*;

@Entity
@Table(name="pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pelicula;
    private String nombre_pelicula;
    private String director_pelicula;
    private String sinopsis_pelicula;
    private Integer boletos_vendidos;

    public Pelicula() {
    }
    public Pelicula(Integer id_pelicula, String nombre_pelicula, String director_pelicula, String sinopsis_pelicula, Integer boletos_vendidos) {

    }

    public Integer getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(Integer id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getNombre_pelicula() {
        return nombre_pelicula;
    }

    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }

    public String getDirector_pelicula() {
        return director_pelicula;
    }

    public void setDirector_pelicula(String director_pelicula) {
        this.director_pelicula = director_pelicula;
    }

    public String getSinopsis_pelicula() {
        return sinopsis_pelicula;
    }

    public void setSinopsis_pelicula(String sinopsis_pelicula) {
        this.sinopsis_pelicula = sinopsis_pelicula;
    }

    public Integer getBoletos_vendidos() {
        return boletos_vendidos;
    }

    public void setBoletos_vendidos(Integer boletos_vendidos) {
        this.boletos_vendidos = boletos_vendidos;
    }
}
