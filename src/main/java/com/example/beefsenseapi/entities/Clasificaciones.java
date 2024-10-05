package com.example.beefsenseapi.entities;
import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "Clasificaciones")
public class Clasificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClasificaciones;

    @Column(name = "categoria")
    private String categoria;
    @Column(name = "precision")
    private Double precision;


    @ManyToOne
    @JoinColumn(name = "modelos_id")
    private Modelos modelos_id;


    public Clasificaciones() { }

    public Clasificaciones(int idClasificaciones, String categoria, Double precision, Modelos modelos_id) {
        this.idClasificaciones = idClasificaciones;
        this.categoria = categoria;
        this.precision = precision;
        this.modelos_id = modelos_id;
    }

    public int getIdClasificaciones() {
        return idClasificaciones;
    }

    public void setIdClasificaciones(int Clasificaciones) {
        this.idClasificaciones = Clasificaciones;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecision() {
        return precision;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
    }

    public Modelos getModelos_id() {
        return modelos_id;
    }

    public void setModelos_id(Modelos modelos_id) {
        this.modelos_id = modelos_id;
    }
}
