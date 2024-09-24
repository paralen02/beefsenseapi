package com.example.beefsenseapi.serviceimplements;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.example.beefsenseapi.repositories.IClasificacionesRepository;
import com.example.beefsenseapi.serviceinterfaces.IClasificacionesService;
import com.example.beefsenseapi.entities.Clasificaciones;
import java.util.List;

@Service
public class ClasificacionesServiceImplement implements IClasificacionesService {
    @Autowired
    private IClasificacionesRepository myRepository;

    // Add an item to table
    @Override
    public void insert(Clasificaciones Clasificaciones) {
        myRepository.save(Clasificaciones);
    }

    // Delete an item by ID on table
    @Override
    public void delete(int idClasificaciones){
        myRepository.deleteById(idClasificaciones);
    }

    // Retrieve an items by ID from table
    @Override
    public Clasificaciones listId(int idClasificaciones){
        return myRepository.findById(idClasificaciones).orElse(new Clasificaciones());
    }

    // Retrieve all items from table
    @Override
    public List<Clasificaciones> list() {
        return myRepository.findAll();
    }
}
