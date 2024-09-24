package com.example.beefsenseapi.serviceinterfaces;
import com.example.beefsenseapi.entities.Operarios;
import java.util.List;

public interface IOperariosService {
    void insert(Operarios Operarios);
    void delete(int id);
    Operarios listId(int id);
    List<Operarios> list();
}