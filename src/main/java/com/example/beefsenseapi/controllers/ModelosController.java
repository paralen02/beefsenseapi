package com.example.beefsenseapi.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.beefsenseapi.dtos.ModelosDTO;
import com.example.beefsenseapi.entities.Modelos;
import com.example.beefsenseapi.serviceinterfaces.IModelosService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/modelos")
public class ModelosController {
    @Autowired
    private IModelosService myService;

    // Add an item to table
    @PostMapping
    public void registrar(@RequestBody ModelosDTO dto) {
        ModelMapper m = new ModelMapper();
        Modelos myItem = m.map(dto, Modelos.class);
        myService.insert(myItem);
    }

    // Delete an item by ID on table
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Retrieve an items by ID from table
    @GetMapping("/{id}")
    public ModelosDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        ModelosDTO myItem = m.map(myService.listId(id), ModelosDTO.class);
        return myItem;
    }

    // Retrieve all items from table
    @GetMapping
    public List<ModelosDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ModelosDTO.class);
        }).collect(Collectors.toList());
    }

    // (Exclusive to controller) Modify values on table
    @PutMapping
    public void modificar(@RequestBody ModelosDTO dto) {
        ModelMapper m = new ModelMapper();
        Modelos d = m.map(dto, Modelos.class);
        myService.insert(d);
    }
}
