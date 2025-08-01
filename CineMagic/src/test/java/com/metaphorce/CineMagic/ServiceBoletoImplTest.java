package com.metaphorce.CineMagic;

import com.metaphorce.CineMagic.entidades.*;
import com.metaphorce.CineMagic.repositorios.*;
import com.metaphorce.CineMagic.servicios.BoletoServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ServiceBoletoImplTest {

    @InjectMocks
    private BoletoServicioImpl boletoServicio;

    @Mock
    private FuncionRepositorio funcionRepositorio;

    @Mock
    private AsientoRepositorio asientoRepositorio;

    @Mock
    private BoletoRepositorio boletoRepositorio;

    @Mock
    private PagoRepositorio pagoRepositorio;

    private Funcion funcion;
    private PeticionPago peticionPago;
    private Sala sala;
    private Pelicula pelicula;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Configurar datos de prueba
        sala = new Sala();
        sala.setId_sala(1);

        pelicula = new Pelicula();
        pelicula.setId_pelicula(1);
        pelicula.setNombre_pelicula("Película de prueba");

        funcion = new Funcion();
        funcion.setId_funcion(1);
        funcion.setSala(sala);
        funcion.setPelicula(pelicula);
        funcion.setFecha_funcion("2025-07-31");
        funcion.setHorario_funcion("15:00");

        // Configurar petición de pago
        peticionPago = new PeticionPago();
        peticionPago.setMetodo_pago("TARJETA");
        List<PeticionAsiento> asientosPedidos = new ArrayList<>();
        PeticionAsiento asiento = new PeticionAsiento();
        asiento.setFila("A");
        asiento.setColumna(1);
        asientosPedidos.add(asiento);
        peticionPago.setPeticionAsientos(asientosPedidos);
    }

    @Test
    void testComprarBoletoExitoso() {
        // Configurar comportamiento de los mocks
        when(funcionRepositorio.findById(1)).thenReturn(Optional.of(funcion));
        when(asientoRepositorio.findByFilaAsientoAndColumnaAsientoAndSala(
                anyString(), anyInt(), any(Sala.class))).thenReturn(Optional.empty());
        when(asientoRepositorio.save(any(Asiento.class))).thenAnswer(i -> i.getArguments()[0]);
        when(boletoRepositorio.save(any(Boleto.class))).thenAnswer(i -> i.getArguments()[0]);
        when(pagoRepositorio.save(any(Pago.class))).thenAnswer(i -> i.getArguments()[0]);

        // Ejecutar prueba
        Pago resultado = boletoServicio.comprarBoleto(peticionPago, 1);

        // Verificaciones
        assertNotNull(resultado, "El pago no debería ser nulo");
        assertEquals("TARJETA", resultado.getMetodo_pago(), "El método de pago no coincide");
        verify(funcionRepositorio).findById(1);
        verify(asientoRepositorio).save(any(Asiento.class));
        verify(boletoRepositorio).save(any(Boleto.class));
        verify(pagoRepositorio).save(any(Pago.class));
    }

    @Test
    void testComprarBoletoFuncionNoExistente() {
        // Configurar comportamiento del mock
        when(funcionRepositorio.findById(999)).thenReturn(Optional.empty());

        // Verificar que se lance la excepción
        assertThrows(RuntimeException.class, () -> {
            boletoServicio.comprarBoleto(peticionPago, 999);
        }, "Debería lanzar una excepción cuando la función no existe");
    }

    @Test
    void testComprarBoletoAsientoOcupado() {
        // Configurar asiento ocupado
        Asiento asientoOcupado = new Asiento();
        asientoOcupado.setBoleto(new Boleto());

        when(funcionRepositorio.findById(1)).thenReturn(Optional.of(funcion));
        when(asientoRepositorio.findByFilaAsientoAndColumnaAsientoAndSala(
                anyString(), anyInt(), any(Sala.class))).thenReturn(Optional.of(asientoOcupado));

        // Verificar que se lance la excepción
        assertThrows(IllegalArgumentException.class, () -> {
            boletoServicio.comprarBoleto(peticionPago, 1);
        }, "Debería lanzar una excepción cuando el asiento está ocupado");
    }

    @Test
    void testCalcularTotalPago() {
        // Crear pago de prueba
        Pago pago = new Pago();
        List<Boleto> boletos = new ArrayList<>();

        // Agregar dos boletos
        Boleto boleto1 = new Boleto();
        boleto1.setPrecio(70);
        Boleto boleto2 = new Boleto();
        boleto2.setPrecio(70);

        boletos.add(boleto1);
        boletos.add(boleto2);

        pago.setBoletos(boletos);
        pago.calcularTotal();

        // Verificar que el total sea correcto
        assertEquals(140, pago.getTotal_pago(),
                "El total del pago debería ser la suma de los precios de los boletos");
    }

    @Test
    void testCalcularTotalPagoSinBoletos() {
        // Crear pago sin boletos
        Pago pago = new Pago();
        pago.setBoletos(new ArrayList<>());
        pago.calcularTotal();

        // Verificar que el total sea cero
        assertEquals(0, pago.getTotal_pago(),
                "El total del pago debería ser cero cuando no hay boletos");
    }
}
