package com.example.beefsenseapi.dtos;
import jakarta.persistence.*;
import com.example.beefsenseapi.entities.*;
import java.time.*;

public class ClasificacionesDTO {
    
    private int idClasificaciones;
    private String categoria;
private Sesiones sesion_id;

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

public Sesiones getSesion_id() {
    return sesion_id;
}

public void setSesion_id(Sesiones sesion_id) {
    this.sesion_id = sesion_id;
}
}
