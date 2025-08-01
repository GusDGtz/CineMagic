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

    @Pattern(regexp = "^[a-gA-G]", message = "Solo existen columnas entre A-G")
    @Column(name = "fila_asiento")
    String filaAsiento;
    @Max(value = 7, message = "El numero de fila debe ser menor a 11 (1-7)")
    @Min(value = 1, message = "El numero de columna debe ser mayor a 0 (1-7)")
    @Column(name = "columna_asiento")
    Integer columnaAsiento;

    public Asiento() {
    }

    public Asiento(Integer id_asiento, Sala sala, Boleto boleto, String filaAsiento, Integer columnaAsiento) {
        this.id_asiento = id_asiento;
        this.sala = sala;
        this.boleto = boleto;
        this.filaAsiento = filaAsiento;
        this.columnaAsiento = columnaAsiento;
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

    public String getFilaAsiento() {
        return filaAsiento;
    }

    public void setFilaAsiento(String fila_asiento) {
        this.filaAsiento = fila_asiento;
    }

    public Integer getColumnaAsiento() {
        return columnaAsiento;
    }

    public void setColumnaAsiento(Integer columna_asiento) {
        this.columnaAsiento = columna_asiento;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }
}
