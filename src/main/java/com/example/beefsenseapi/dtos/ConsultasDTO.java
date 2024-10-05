package com.example.beefsenseapi.dtos;
import jakarta.persistence.*;
import com.example.beefsenseapi.entities.*;
import java.time.*;

public class ConsultasDTO {

    private int idConsultas;
    private String username;
    private String correo;
    private String motivo;
    private String descripcion;
    private LocalDateTime fecha;
    private Boolean estado;

    public int getIdConsultas() {
        return idConsultas;
    }

    public void setIdConsultas(int idConsultas) {
        this.idConsultas = idConsultas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
