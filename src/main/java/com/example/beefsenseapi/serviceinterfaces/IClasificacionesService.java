package com.example.beefsenseapi.serviceinterfaces;
import com.example.beefsenseapi.entities.Clasificaciones;
import java.util.List;

public interface IClasificacionesService {
    void insert(Clasificaciones Clasificaciones);
    void delete(int id);
    Clasificaciones listId(int id);
    List<Clasificaciones> list();
}