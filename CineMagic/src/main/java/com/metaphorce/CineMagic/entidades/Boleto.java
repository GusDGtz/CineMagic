package com.metaphorce.CineMagic.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.annotation.TypeAlias;

@Entity
@Table(name="boleto")
public class Boleto {
    // ATRIBUTOS
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id_boleto;

    @ManyToOne
    @JoinColumn(name = "id_funcion")
    private Funcion funcion;

    @ManyToOne
    @JoinColumn(name = "id_pago")
    @JsonIgnore
    private Pago pago;

    private Integer precio=70;

    // CONSTRUCTORES
    public Boleto() {
    }
    public Boleto(Integer id_boleto, Funcion funcion, Pago pago) {
        this.id_boleto = id_boleto;
        this.funcion = funcion;
        this.pago = pago;
    }

    // GET - SET

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Integer getId_boleto() {
        return id_boleto;
    }

    public void setId_boleto(Integer id_boleto) {
        this.id_boleto = id_boleto;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
