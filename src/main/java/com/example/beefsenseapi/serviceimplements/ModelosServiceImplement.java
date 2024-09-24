package com.example.beefsenseapi.serviceimplements;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.example.beefsenseapi.repositories.IModelosRepository;
import com.example.beefsenseapi.serviceinterfaces.IModelosService;
import com.example.beefsenseapi.entities.Modelos;
import java.util.List;

@Service
public class ModelosServiceImplement implements IModelosService {
    @Autowired
    private IModelosRepository myRepository;

    // Add an item to table
    @Override
    public void insert(Modelos Modelos) {
        myRepository.save(Modelos);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idModelos){
        myRepository.deleteById(idModelos);
    }

    // Retrieve an items by ID from table
    @Override
    public Modelos listId(int idModelos){
        return myRepository.findById(idModelos).orElse(new Modelos());
    }

    // Retrieve all items from table
    @Override
    public List<Modelos> list() {
        return myRepository.findAll();
    }
}
