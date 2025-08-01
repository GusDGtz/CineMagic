package com.metaphorce.CineMagic.servicios;

import com.metaphorce.CineMagic.entidades.Pago;
import com.metaphorce.CineMagic.entidades.PeticionPago;

import java.util.List;

public interface BoletoServicio {

    Pago comprarBoleto(PeticionPago peticion, Integer id_funcion);


}
