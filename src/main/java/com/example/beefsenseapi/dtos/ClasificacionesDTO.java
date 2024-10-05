package com.example.beefsenseapi.dtos;
import jakarta.persistence.*;
import com.example.beefsenseapi.entities.*;
import java.time.*;

public class ClasificacionesDTO {

    private int idClasificaciones;
    private String categoria;
    private Double precision;
    private Modelos modelos_id;

    public int getIdClasificaciones() {
        return idClasificaciones;
    }

    public void setIdClasificaciones(int idClasificaciones) {
        this.idClasificaciones = idClasificaciones;
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
