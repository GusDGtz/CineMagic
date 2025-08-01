package com.metaphorce.CineMagic.entidades;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PeticionPago {
    // ATRIBUTOS
    @NotEmpty(message = "Debe seleccionar al menos un asiento")
    @NotNull(message = "Debe seleccionar al menos un asiento")
    private List<PeticionAsiento> peticionAsientos;
    @NotEmpty(message = "Debes de especificar un metodo de pago")
    @NotNull(message = "Debes de especificar un metodo de pago")
    private String metodo_pago;

    // CONSTRUCTORES

    public PeticionPago(List<PeticionAsiento> peticionAsientos, String metodo_pago, String referencia_pago) {
        this.peticionAsientos = peticionAsientos;
        this.metodo_pago = metodo_pago;
    }

    public PeticionPago() {
    }

    // GET SET
    public List<PeticionAsiento> getPeticionAsientos() {
        return peticionAsientos;
    }

    public void setPeticionAsientos(List<PeticionAsiento> peticionAsientos) {
        this.peticionAsientos = peticionAsientos;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }


}