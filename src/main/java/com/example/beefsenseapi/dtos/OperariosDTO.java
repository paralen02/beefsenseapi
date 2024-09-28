package com.example.beefsenseapi.dtos;
import jakarta.persistence.*;
import com.example.beefsenseapi.entities.*;
import java.time.*;

public class OperariosDTO {

    private int idOperarios;
    private String nombre;
    private String apellido;
    private Users users_id;

    public int getIdOperarios() {
        return idOperarios;
    }

    public void setIdOperarios(int idOperarios) {
        this.idOperarios = idOperarios;
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

    public Users getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Users users_id) {
        this.users_id = users_id;
    }
}
