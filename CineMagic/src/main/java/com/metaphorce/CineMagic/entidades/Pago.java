package com.metaphorce.CineMagic.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pago")
public class Pago {
    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pago;
    private Integer total_pago;
    private String metodo_pago;
    private LocalDateTime fecha_pago;
    private String referencia_pago;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "pago")
    private List<Boleto> boletos;


    // CONSTRUCTORES
    public Pago() {
    }
    public Pago(String metodo_pago, LocalDateTime fecha_pago, String referencia_pago) {
        this.metodo_pago = metodo_pago;
        this.fecha_pago = fecha_pago;
        this.referencia_pago = referencia_pago;
        calcularTotal();
    }
    public Pago(Integer id_pago,String metodo_pago, LocalDateTime fecha_pago, String referencia_pago, Usuario usuario) {
        this.id_pago = id_pago;
        this.metodo_pago = metodo_pago;
        this.fecha_pago = fecha_pago;
        this.referencia_pago = referencia_pago;
        this.usuario = usuario;
        calcularTotal();
    }

     public void calcularTotal() {
        total_pago = boletos.stream()
                .mapToInt(Boleto::getPrecio)
                .sum(); // Usa el precio que viene desde la BD
    }

    // GET - SET


    public Integer getId_pago() {
        return id_pago;
    }

    public void setId_pago(Integer id_pago) {
        this.id_pago = id_pago;
    }

    public Integer getTotal_pago() {
        return total_pago;
    }

    public void setTotal_pago(Integer total_pago) {
        this.total_pago = total_pago;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public LocalDateTime getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDateTime fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getReferencia_pago() {
        return referencia_pago;
    }

    public void setReferencia_pago(String referencia_pago) {
        this.referencia_pago = referencia_pago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }
}
