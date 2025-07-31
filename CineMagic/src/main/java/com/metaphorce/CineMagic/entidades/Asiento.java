package com.metaphorce.CineMagic.entidades;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="asiento")
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_asiento;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    Sala sala;

    @ManyToOne
    @JoinColumn(name = "id_boleto")
    Boleto boleto;

    @Pattern(regexp = "^[a-jA-J]", message = "Solo existen columnas entre A-J")
    String fila_asiento;
    @Max(value = 10, message = "El numero de fila debe ser menor a 11 (1-10)")
    @Min(value = 1, message = "El numero de columna debe ser mayor a 0 (1-10)")
    Integer columna_asiento;

    public Asiento() {
    }

    public Asiento(Integer id_asiento, Sala sala, Boleto boleto, String fila_asiento, Integer columna_asiento) {
        this.id_asiento = id_asiento;
        this.sala = sala;
        this.boleto = boleto;
        this.fila_asiento = fila_asiento;
        this.columna_asiento = columna_asiento;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Integer getId_asiento() {
        return id_asiento;
    }

    public void setId_asiento(Integer id_asiento) {
        this.id_asiento = id_asiento;
    }

    public String getFila_asiento() {
        return fila_asiento;
    }

    public void setFila_asiento(String fila_asiento) {
        this.fila_asiento = fila_asiento;
    }

    public Integer getColumna_asiento() {
        return columna_asiento;
    }

    public void setColumna_asiento(Integer columna_asiento) {
        this.columna_asiento = columna_asiento;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }
}
