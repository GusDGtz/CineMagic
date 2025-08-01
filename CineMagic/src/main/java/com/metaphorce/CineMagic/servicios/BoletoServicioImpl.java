package com.metaphorce.CineMagic.servicios;

import com.metaphorce.CineMagic.entidades.*;
import com.metaphorce.CineMagic.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BoletoServicioImpl implements BoletoServicio{

    @Autowired
    FuncionRepositorio funcionRepositorio;
    @Autowired
    AsientoRepositorio asientoRepositorio;
    @Autowired
    BoletoRepositorio boletoRepositorio;
    @Autowired
    PagoRepositorio pagoRepositorio;
    @Autowired
    private UsuarioRepositorio usuariorepositorio;

    @Override
    public Pago comprarBoleto(PeticionPago peticion, Integer id_funcion) {
        Funcion funcion = funcionRepositorio.findById(id_funcion)
                .orElseThrow(() -> new RuntimeException("Función no encontrada, id incorrecto"));

        List<Asiento> asientos = new ArrayList<>();

        // Verificar asientos...
        List<PeticionAsiento> asientosPedidos = peticion.getPeticionAsientos();
        for (PeticionAsiento req : asientosPedidos) {
            Asiento asiento = asientoRepositorio.findByFilaAsientoAndColumnaAsientoAndSala(
                    req.getFila(), req.getColumna(), funcion.getSala()
            ).orElse(null);
            if (asiento == null) {
                asiento = new Asiento();
                asiento.setFilaAsiento(req.getFila());
                asiento.setColumnaAsiento(req.getColumna());
                asiento.setSala(funcion.getSala());
            }
            if (asiento.getBoleto() != null) {
                System.out.println("Se escogió un asiento ya ocupado");
                return null;


            }
            asientos.add(asiento);
        }

        // Crear el pago
        Pago pago = new Pago();
        pago.setMetodo_pago(peticion.getMetodo_pago());
        pago.setFecha_pago(LocalDateTime.now());
        pago.setReferencia_pago(UUID.randomUUID().toString());

        // Crear los boletos
        List<Boleto> boletos = new ArrayList<>();
        for (Asiento asiento : asientos) {
            Boleto boleto = new Boleto();
            boleto.setFuncion(funcion);
            boleto.setPago(pago);
            boletos.add(boleto);
        }

        // Establecer boletos y calcular total antes de guardar
        pago.setBoletos(boletos);
        pago.calcularTotal();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // usuario del token
        String nombre = auth.getName();
        Usuario usuario = usuariorepositorio.findByNombreUsuario(nombre).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        pago.setUsuario(usuario);

        // Guardar el pago después de calcular el total
        pago = pagoRepositorio.save(pago);

        // Guardar boletos y asientos
        for (int i = 0; i < boletos.size(); i++) {
            Boleto boleto = boletos.get(i);
            boleto = boletoRepositorio.save(boleto);
            
            Asiento asiento = asientos.get(i);
            asiento.setBoleto(boleto);
            asientoRepositorio.save(asiento);
        }

        return pago;
    }
}