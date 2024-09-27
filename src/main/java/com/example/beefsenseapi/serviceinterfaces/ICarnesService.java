package com.example.beefsenseapi.serviceinterfaces;
import com.example.beefsenseapi.entities.Carnes;
import java.util.List;

public interface ICarnesService {
    void insert(Carnes Carnes);
    void delete(int id);
    Carnes listId(int id);
    List<Carnes> list();
    void updateImagen(int id, String imagen); // Add this method

}