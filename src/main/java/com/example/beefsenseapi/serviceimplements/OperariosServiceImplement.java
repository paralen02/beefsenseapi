package com.example.beefsenseapi.serviceimplements;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.example.beefsenseapi.repositories.IOperariosRepository;
import com.example.beefsenseapi.serviceinterfaces.IOperariosService;
import com.example.beefsenseapi.entities.Operarios;
import java.util.List;

@Service
public class OperariosServiceImplement implements IOperariosService {
    @Autowired
    private IOperariosRepository myRepository;

    // Add an item to table
    @Override
    public void insert(Operarios Operarios) {
        myRepository.save(Operarios);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idOperarios){
        myRepository.deleteById(idOperarios);
    }

    // Retrieve an items by ID from table
    @Override
    public Operarios listId(int idOperarios){
        return myRepository.findById(idOperarios).orElse(new Operarios());
    }

    // Retrieve all items from table
    @Override
    public List<Operarios> list() {
        return myRepository.findAll();
    }
}
