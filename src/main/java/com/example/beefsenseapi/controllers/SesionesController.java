package com.example.beefsenseapi.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.beefsenseapi.dtos.SesionesDTO;
import com.example.beefsenseapi.entities.Sesiones;
import com.example.beefsenseapi.serviceinterfaces.ISesionesService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sesiones")
public class SesionesController {
    @Autowired
    private ISesionesService myService;

    // Add an item to table
    @PostMapping
    public void registrar(@RequestBody SesionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Sesiones myItem = m.map(dto, Sesiones.class);
        myService.insert(myItem);
    }

    // Delete an item by ID on table
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Retrieve an items by ID from table
    @GetMapping("/{id}")
    public SesionesDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        SesionesDTO myItem = m.map(myService.listId(id), SesionesDTO.class);
        return myItem;
    }

    // Retrieve all items from table
    @GetMapping
    public List<SesionesDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SesionesDTO.class);
        }).collect(Collectors.toList());
    }

    // (Exclusive to controller) Modify values on table
    @PutMapping
    public void modificar(@RequestBody SesionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Sesiones d = m.map(dto, Sesiones.class);
        myService.insert(d);
    }
}
