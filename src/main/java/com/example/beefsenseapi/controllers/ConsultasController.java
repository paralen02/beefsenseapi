package com.example.beefsenseapi.controllers;
import com.example.beefsenseapi.dtos.OperariosDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.beefsenseapi.dtos.ConsultasDTO;
import com.example.beefsenseapi.entities.Consultas;
import com.example.beefsenseapi.serviceinterfaces.IConsultasService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultas")
public class ConsultasController {
    @Autowired
    private IConsultasService myService;

    // Add an item to table
    @PostMapping
    public void registrar(@RequestBody ConsultasDTO dto) {
        ModelMapper m = new ModelMapper();
        Consultas myItem = m.map(dto, Consultas.class);
        myService.insert(myItem);
    }

    // Delete an item by ID on table
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Retrieve an items by ID from table
    @GetMapping("/{id}")
    public ConsultasDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        ConsultasDTO myItem = m.map(myService.listId(id), ConsultasDTO.class);
        return myItem;
    }

    // Retrieve all items from table
    @GetMapping
    public List<ConsultasDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConsultasDTO.class);
        }).collect(Collectors.toList());
    }

    // (Exclusive to controller) Modify values on table
    @PutMapping
    public void modificar(@RequestBody ConsultasDTO dto) {
        ModelMapper m = new ModelMapper();
        Consultas d = m.map(dto, Consultas.class);
        myService.insert(d);
    }

    @PatchMapping("/{id}")
    public void patchConsulta(@PathVariable("id") Integer id, @RequestBody ConsultasDTO dto) {
        myService.patchConsulta(id, dto);
    }
}
