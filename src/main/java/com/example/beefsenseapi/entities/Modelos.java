package com.example.beefsenseapi.entities;
import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "Modelos")
public class Modelos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModelos;

    @Column(name = "version")
    private String version;
    @Column(name = "operativo")
    private Boolean operativo;



    public Modelos() { }

    public Modelos(int idModelos, String version, Boolean operativo) {
        this.idModelos = idModelos;
        this.version = version;
        this.operativo = operativo;
    }

    public int getIdModelos() {
        return idModelos;
    }

    public void setIdModelos(int Modelos) {
        this.idModelos = Modelos;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getOperativo() {
        return operativo;
    }

    public void setOperativo(Boolean operativo) {
        this.operativo = operativo;
    }
}
