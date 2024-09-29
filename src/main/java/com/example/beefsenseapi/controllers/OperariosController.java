package com.example.beefsenseapi.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.beefsenseapi.dtos.OperariosDTO;
import com.example.beefsenseapi.entities.Operarios;
import com.example.beefsenseapi.serviceinterfaces.IOperariosService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/operarios")
public class OperariosController {
    @Autowired
    private IOperariosService myService;

    // Add an item to table
    @PostMapping
    public void registrar(@RequestBody OperariosDTO dto) {
        ModelMapper m = new ModelMapper();
        Operarios myItem = m.map(dto, Operarios.class);
        myService.insert(myItem);
    }

    // Delete an item by ID on table
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id")Integer id){
        myService.delete(id);
    }

    // Retrieve an items by ID from table
    @GetMapping("/{id}")
    public OperariosDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        OperariosDTO myItem = m.map(myService.listId(id), OperariosDTO.class);
        return myItem;
    }

    // Retrieve all items from table
    @GetMapping
    public List<OperariosDTO> listar(){
        return myService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, OperariosDTO.class);
        }).collect(Collectors.toList());
    }

    // (Exclusive to controller) Modify values on table
    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody OperariosDTO dto) {
        ModelMapper m = new ModelMapper();
        Operarios d = m.map(dto, Operarios.class);
        myService.insert(d);
    }
    @GetMapping("/buscar/{username}")
    public OperariosDTO findByUsername(@PathVariable("username") String username) {
        ModelMapper m = new ModelMapper();
        OperariosDTO myItem = m.map(myService.findByUsername(username), OperariosDTO.class);
        return myItem;
    }

    @PatchMapping("/{id}")
    public void patchOperario(@PathVariable("id") Integer id, @RequestBody OperariosDTO dto) {
        myService.patchOperario(id, dto);
    }
}
