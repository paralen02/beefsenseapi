package com.example.beefsenseapi.entities;
import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "Carnes")
public class Carnes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarnes;

    @Column(name = "peso")
private String peso;
@Column(name = "sexo")
private String sexo;
@Column(name = "fecha")
private LocalDateTime fecha;
@Column(name = "conformacion")
private String conformacion;
@Column(name = "grasa")
private String grasa;
@Column(name = "imagen", length = 1024)
private String imagen;


@ManyToOne
@JoinColumn(name = "operarios_id")
private Operarios operarios_id;


    public Carnes() { }

    public Carnes(int idCarnes, String peso, String sexo, LocalDateTime fecha, String conformacion, String grasa, String imagen, Operarios operarios_id) {
        this.idCarnes = idCarnes;
        this.peso = peso;
this.sexo = sexo;
this.fecha = fecha;
this.conformacion = conformacion;
this.grasa = grasa;
this.imagen = imagen;
this.operarios_id = operarios_id;
    }

    public int getIdCarnes() {
        return idCarnes;
    }

    public void setIdCarnes(int Carnes) {
        this.idCarnes = Carnes;
    }

    public String getPeso() {
    return peso;
}

public void setPeso(String peso) {
    this.peso = peso;
}

public String getSexo() {
    return sexo;
}

public void setSexo(String sexo) {
    this.sexo = sexo;
}

public LocalDateTime getFecha() {
    return fecha;
}

public void setFecha(LocalDateTime fecha) {
    this.fecha = fecha;
}

public String getConformacion() {
    return conformacion;
}

public void setConformacion(String conformacion) {
    this.conformacion = conformacion;
}

public String getGrasa() {
    return grasa;
}

public void setGrasa(String grasa) {
    this.grasa = grasa;
}

public String getImagen() {
    return imagen;
}

public void setImagen(String imagen) {
    this.imagen = imagen;
}

public Operarios getOperarios_id() {
    return operarios_id;
}

public void setOperarios_id(Operarios operarios_id) {
    this.operarios_id = operarios_id;
}
}
