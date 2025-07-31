package com.metaphorce.CineMagic.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.TypeAlias;

@Entity
@Table(name="boleto")
public class Boleto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)

}
