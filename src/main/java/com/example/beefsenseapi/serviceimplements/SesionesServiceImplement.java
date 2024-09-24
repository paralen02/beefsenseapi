package com.example.beefsenseapi.serviceimplements;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.example.beefsenseapi.repositories.ISesionesRepository;
import com.example.beefsenseapi.serviceinterfaces.ISesionesService;
import com.example.beefsenseapi.entities.Sesiones;
import java.util.List;

@Service
public class SesionesServiceImplement implements ISesionesService {
    @Autowired
    private ISesionesRepository myRepository;

    // Add an item to table
    @Override
    public void insert(Sesiones Sesiones) {
        myRepository.save(Sesiones);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idSesiones){
        myRepository.deleteById(idSesiones);
    }

    // Retrieve an items by ID from table
    @Override
    public Sesiones listId(int idSesiones){
        return myRepository.findById(idSesiones).orElse(new Sesiones());
    }

    // Retrieve all items from table
    @Override
    public List<Sesiones> list() {
        return myRepository.findAll();
    }
}
