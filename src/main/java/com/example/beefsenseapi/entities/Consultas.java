package com.example.beefsenseapi.entities;
import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "Consultas")
public class Consultas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsultas;

    @Column(name = "username")
    private String username;
    @Column(name = "correo")
    private String correo;
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "descripcion", length = 1024)
    private String descripcion;
    @Column(name = "fecha")
    private LocalDateTime fecha;
    @Column(name = "estado")
    private Boolean estado;



    public Consultas() { }

    public Consultas(int idConsultas, String username, String correo, String motivo, String descripcion, LocalDateTime fecha, Boolean estado) {
        this.idConsultas = idConsultas;
        this.username = username;
        this.correo = correo;
        this.motivo = motivo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIdConsultas() {
        return idConsultas;
    }

    public void setIdConsultas(int Consultas) {
        this.idConsultas = Consultas;
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
