package com.metaphorce.CineMagic.entidades;

import jakarta.validation.constraints.NotNull;

public class IngresoUsuario {
    @NotNull(message = "El campo nombre de usuario es obligatorio")
    private String nombreUsuario;
    @NotNull(message = "El campo contrasenia es obligatorio")
    private String contrasenia;

    // Nombre correctos textuales para el JSON que lo construye en Postman
    public IngresoUsuario(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public IngresoUsuario() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
