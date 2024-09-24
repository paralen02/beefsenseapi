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
@Column(name = "precision")
private Double precision;
@Column(name = "despliegue")
private LocalDateTime despliegue;
@Column(name = "operativo")
private Boolean operativo;

    

    public Modelos() { }

    public Modelos(int idModelos, String version, Double precision, LocalDateTime despliegue, Boolean operativo) {
        this.idModelos = idModelos;
        this.version = version;
this.precision = precision;
this.despliegue = despliegue;
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

public Double getPrecision() {
    return precision;
}

public void setPrecision(Double precision) {
    this.precision = precision;
}

public LocalDateTime getDespliegue() {
    return despliegue;
}

public void setDespliegue(LocalDateTime despliegue) {
    this.despliegue = despliegue;
}

public Boolean getOperativo() {
    return operativo;
}

public void setOperativo(Boolean operativo) {
    this.operativo = operativo;
}
}
