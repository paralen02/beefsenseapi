package com.example.beefsenseapi.serviceimplements;
import com.example.beefsenseapi.dtos.ConsultasDTO;
import com.example.beefsenseapi.dtos.OperariosDTO;
import com.example.beefsenseapi.entities.Operarios;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.example.beefsenseapi.repositories.IConsultasRepository;
import com.example.beefsenseapi.serviceinterfaces.IConsultasService;
import com.example.beefsenseapi.entities.Consultas;
import java.util.List;

@Service
public class ConsultasServiceImplement implements IConsultasService {
    @Autowired
    private IConsultasRepository myRepository;

    // Add an item to table
    @Override
    public void insert(Consultas Consultas) {
        myRepository.save(Consultas);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idConsultas){
        myRepository.deleteById(idConsultas);
    }

    // Retrieve an items by ID from table
    @Override
    public Consultas listId(int idConsultas){
        return myRepository.findById(idConsultas).orElse(new Consultas());
    }

    // Retrieve all items from table
    @Override
    public List<Consultas> list() {
        return myRepository.findAll();
    }

    @Override
    @Transactional
    public void patchConsulta(Integer id, ConsultasDTO dto) {
        Consultas consulta = myRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta not found"));
        consulta.setEstado(dto.getEstado());
        myRepository.save(consulta);
    }
}
