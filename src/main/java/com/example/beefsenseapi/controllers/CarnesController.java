package com.example.beefsenseapi.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.beefsenseapi.dtos.CarnesDTO;
import com.example.beefsenseapi.entities.Carnes;
import com.example.beefsenseapi.serviceinterfaces.ICarnesService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carnes")
public class CarnesController {
    @Autowired
    private ICarnesService myService;

    // Add an item to table
    @PostMapping
    public void registrar(@RequestBody CarnesDTO dto) {
        ModelMapper m = new ModelMapper();
        Carnes myItem = m.map(dto, Carnes.class);
        myService.insert(myItem);
    }

    // Delete an item by ID on table
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Retrieve an items by ID from table
    @GetMapping("/{id}")
    public CarnesDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        CarnesDTO myItem = m.map(myService.listId(id), CarnesDTO.class);
        return myItem;
    }

    // Retrieve all items from table
    @GetMapping
    public List<CarnesDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CarnesDTO.class);
        }).collect(Collectors.toList());
    }

    // (Exclusive to controller) Modify values on table
    @PutMapping
    public void modificar(@RequestBody CarnesDTO dto) {
        ModelMapper m = new ModelMapper();
        Carnes d = m.map(dto, Carnes.class);
        myService.insert(d);
    }
}
