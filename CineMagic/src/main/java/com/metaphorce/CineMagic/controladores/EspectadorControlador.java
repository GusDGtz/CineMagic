package com.metaphorce.CineMagic.controladores;

import com.metaphorce.CineMagic.entidades.Pago;
import com.metaphorce.CineMagic.entidades.PeticionPago;
import com.metaphorce.CineMagic.servicios.BoletoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CineMagic/espectador")
public class EspectadorControlador {

    @Autowired
    BoletoServicio servicio;


    @PreAuthorize( "hasRole('USER')")
    @PostMapping("/comprar-boletos")
    public ResponseEntity<?> comprarBoletos(@RequestBody PeticionPago peticion, @RequestParam Integer id_funcion){
        Pago pago = servicio.comprarBoleto(peticion, id_funcion);
        if(pago == null)
            return ResponseEntity.badRequest().body("Asiento ya ocupado");
        return ResponseEntity.ok(pago);
    }
}
