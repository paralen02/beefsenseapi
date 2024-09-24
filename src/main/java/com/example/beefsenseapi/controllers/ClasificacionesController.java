package com.example.beefsenseapi.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.beefsenseapi.dtos.ClasificacionesDTO;
import com.example.beefsenseapi.entities.Clasificaciones;
import com.example.beefsenseapi.serviceinterfaces.IClasificacionesService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clasificaciones")
public class ClasificacionesController {
    @Autowired
    private IClasificacionesService myService;

    // Add an item to table
    @PostMapping
    public void registrar(@RequestBody ClasificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Clasificaciones myItem = m.map(dto, Clasificaciones.class);
        myService.insert(myItem);
    }

    // Delete an item by ID on table
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Retrieve an items by ID from table
    @GetMapping("/{id}")
    public ClasificacionesDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        ClasificacionesDTO myItem = m.map(myService.listId(id), ClasificacionesDTO.class);
        return myItem;
    }

    // Retrieve all items from table
    @GetMapping
    public List<ClasificacionesDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ClasificacionesDTO.class);
        }).collect(Collectors.toList());
    }

    // (Exclusive to controller) Modify values on table
    @PutMapping
    public void modificar(@RequestBody ClasificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Clasificaciones d = m.map(dto, Clasificaciones.class);
        myService.insert(d);
    }
}
