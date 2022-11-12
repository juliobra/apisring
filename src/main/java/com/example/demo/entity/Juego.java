package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "juegos")
@Getter
@Setter
@NoArgsConstructor

public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "plataformaConsola")
    private String plataformaConsola;

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "anio")
    private int anio;

    @Column(name = "muntoAbierto")
    private boolean mundoAbierto;

    public Juego(String nombre, String plataformaConsola, String empresa, int anio, boolean mundoAbierto) {

        this.nombre = nombre;
        this.plataformaConsola = plataformaConsola;
        this.empresa = empresa;
        this.anio = anio;
        this.mundoAbierto = mundoAbierto;
    }

}
