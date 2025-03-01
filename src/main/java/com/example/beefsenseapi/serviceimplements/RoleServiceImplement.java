package com.example.beefsenseapi.serviceimplements;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.example.beefsenseapi.entities.Role;
import com.example.beefsenseapi.repositories.IRoleRepository;
import com.example.beefsenseapi.serviceinterfaces.IRoleService;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository myRepository;

    // Add an item to table
    @Override
    public void insert(Role Role) {
        myRepository.save(Role);
    }

    // Delete an item by ID on table
    @Override
    public void delete(Long idRole){
        myRepository.deleteById(idRole);
    }

    // Retrieve an items by ID from table
    @Override
    public Role listId(Long idRole){
        return myRepository.findById(idRole).orElse(new Role());
    }

    // Retrieve all items from table
    @Override
    public List<Role> list() {
        return myRepository.findAll();
    }

    @Override
    public List<Role> findRolesByUsername(String username) {
        return myRepository.findRolesByUsername(username);
    }
}
