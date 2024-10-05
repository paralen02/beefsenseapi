package com.example.beefsenseapi.serviceinterfaces;
import com.example.beefsenseapi.dtos.ConsultasDTO;
import com.example.beefsenseapi.dtos.OperariosDTO;
import com.example.beefsenseapi.entities.Consultas;
import java.util.List;

public interface IConsultasService {
    void insert(Consultas Consultas);
    void delete(int id);
    Consultas listId(int id);
    List<Consultas> list();
    void patchConsulta(Integer id, ConsultasDTO dto); // New method

}