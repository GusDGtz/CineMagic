package com.metaphorce.CineMagic.entidades;

import jakarta.persistence.*;

@Entity
@Table(name="sala")
public class Sala {
    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sala;
    private Integer numero_sala;
    private Integer capacidad_sala;

    // constructores
    public Sala() {
    }
    public Sala(Integer id_sala, Integer numero_sala, Integer capacidad_sala) {
    }

    // get set
    public Integer getId_sala() {
        return id_sala;
    }

    public void setId_sala(Integer id_sala) {
        this.id_sala = id_sala;
    }

    public Integer getNumero_sala() {
        return numero_sala;
    }

    public void setNumero_sala(Integer numero_sala) {
        this.numero_sala = numero_sala;
    }

    public Integer getCapacidad_sala() {
        return capacidad_sala;
    }

    public void setCapacidad_sala(Integer capacidad_sala) {
        this.capacidad_sala = capacidad_sala;
    }
}
