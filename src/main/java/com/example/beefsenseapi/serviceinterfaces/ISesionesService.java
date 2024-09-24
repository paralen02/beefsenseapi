package com.example.beefsenseapi.serviceinterfaces;
import com.example.beefsenseapi.entities.Sesiones;
import java.util.List;

public interface ISesionesService {
    void insert(Sesiones Sesiones);
    void delete(int id);
    Sesiones listId(int id);
    List<Sesiones> list();
}