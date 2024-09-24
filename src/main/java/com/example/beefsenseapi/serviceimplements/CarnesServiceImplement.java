package com.example.beefsenseapi.serviceimplements;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.example.beefsenseapi.repositories.ICarnesRepository;
import com.example.beefsenseapi.serviceinterfaces.ICarnesService;
import com.example.beefsenseapi.entities.Carnes;
import java.util.List;

@Service
public class CarnesServiceImplement implements ICarnesService {
    @Autowired
    private ICarnesRepository myRepository;

    // Add an item to table
    @Override
    public void insert(Carnes Carnes) {
        myRepository.save(Carnes);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idCarnes){
        myRepository.deleteById(idCarnes);
    }

    // Retrieve an items by ID from table
    @Override
    public Carnes listId(int idCarnes){
        return myRepository.findById(idCarnes).orElse(new Carnes());
    }

    // Retrieve all items from table
    @Override
    public List<Carnes> list() {
        return myRepository.findAll();
    }
}
