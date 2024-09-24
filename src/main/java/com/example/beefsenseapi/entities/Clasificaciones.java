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

    
@ManyToOne
@JoinColumn(name = "sesiones_id")
private Sesiones sesion_id;


    public Clasificaciones() { }

    public Clasificaciones(int idClasificaciones, String categoria, Sesiones sesion_id) {
        this.idClasificaciones = idClasificaciones;
        this.categoria = categoria;
this.sesion_id = sesion_id;
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

public Sesiones getSesion_id() {
    return sesion_id;
}

public void setSesion_id(Sesiones sesion_id) {
    this.sesion_id = sesion_id;
}
}
