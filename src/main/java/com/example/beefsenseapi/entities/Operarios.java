package com.example.beefsenseapi.entities;
import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "Operarios")
public class Operarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOperarios;

    @Column(name = "nombre")
private String nombre;
@Column(name = "apellido")
private String apellido;
@Column(name = "telefono")
private String telefono;
@Column(name = "turno")
private String turno;

    
@ManyToOne
@JoinColumn(name = "users_id")
private Users users_id;


    public Operarios() { }

    public Operarios(int idOperarios, String nombre, String apellido, String telefono, String turno, Users users_id) {
        this.idOperarios = idOperarios;
        this.nombre = nombre;
this.apellido = apellido;
this.telefono = telefono;
this.turno = turno;
this.users_id = users_id;
    }

    public int getIdOperarios() {
        return idOperarios;
    }

    public void setIdOperarios(int Operarios) {
        this.idOperarios = Operarios;
    }

    public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getApellido() {
    return apellido;
}

public void setApellido(String apellido) {
    this.apellido = apellido;
}

public String getTelefono() {
    return telefono;
}

public void setTelefono(String telefono) {
    this.telefono = telefono;
}

public String getTurno() {
    return turno;
}

public void setTurno(String turno) {
    this.turno = turno;
}

public Users getUsers_id() {
    return users_id;
}

public void setUsers_id(Users users_id) {
    this.users_id = users_id;
}
}
