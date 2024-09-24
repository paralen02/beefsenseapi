package com.example.beefsenseapi.entities;
import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "Sesiones")
public class Sesiones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSesiones;

    @Column(name = "inicio")
private LocalDateTime inicio;
@Column(name = "fin")
private LocalDateTime fin;

    
@ManyToOne
@JoinColumn(name = "modelos_id")
private Modelos modelos_id;

@ManyToOne
@JoinColumn(name = "carnes_id")
private Carnes carnes_id;

@ManyToOne
@JoinColumn(name = "operarios_id")
private Operarios operarios_id;


    public Sesiones() { }

    public Sesiones(int idSesiones, LocalDateTime inicio, LocalDateTime fin, Modelos modelos_id, Carnes carnes_id, Operarios operarios_id) {
        this.idSesiones = idSesiones;
        this.inicio = inicio;
this.fin = fin;
this.modelos_id = modelos_id;
this.carnes_id = carnes_id;
this.operarios_id = operarios_id;
    }

    public int getIdSesiones() {
        return idSesiones;
    }

    public void setIdSesiones(int Sesiones) {
        this.idSesiones = Sesiones;
    }

    public LocalDateTime getInicio() {
    return inicio;
}

public void setInicio(LocalDateTime inicio) {
    this.inicio = inicio;
}

public LocalDateTime getFin() {
    return fin;
}

public void setFin(LocalDateTime fin) {
    this.fin = fin;
}

public Modelos getModelos_id() {
    return modelos_id;
}

public void setModelos_id(Modelos modelos_id) {
    this.modelos_id = modelos_id;
}

public Carnes getCarnes_id() {
    return carnes_id;
}

public void setCarnes_id(Carnes carnes_id) {
    this.carnes_id = carnes_id;
}

public Operarios getOperarios_id() {
    return operarios_id;
}

public void setOperarios_id(Operarios operarios_id) {
    this.operarios_id = operarios_id;
}
}
