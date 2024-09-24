package com.example.beefsenseapi.dtos;
import jakarta.persistence.*;
import com.example.beefsenseapi.entities.*;
import java.time.*;

public class CarnesDTO {
    
    private int idCarnes;
    private String peso;
private String sexo;
private LocalDateTime fecha;
private String conformacion;
private String grasa;
private String imagen;
private Operarios operarios_id;

    public int getIdCarnes() {
        return idCarnes;
    }

    public void setIdCarnes(int idCarnes) {
        this.idCarnes = idCarnes;
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
