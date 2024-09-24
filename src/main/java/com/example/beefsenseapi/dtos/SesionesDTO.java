package com.example.beefsenseapi.dtos;
import jakarta.persistence.*;
import com.example.beefsenseapi.entities.*;
import java.time.*;

public class SesionesDTO {
    
    private int idSesiones;
    private LocalDateTime inicio;
private LocalDateTime fin;
private Modelos modelos_id;
private Carnes carnes_id;
private Operarios operarios_id;

    public int getIdSesiones() {
        return idSesiones;
    }

    public void setIdSesiones(int idSesiones) {
        this.idSesiones = idSesiones;
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
