package com.example.beefsenseapi.serviceinterfaces;
import com.example.beefsenseapi.entities.Modelos;
import java.util.List;

public interface IModelosService {
    void insert(Modelos Modelos);
    void delete(int id);
    Modelos listId(int id);
    List<Modelos> list();
}