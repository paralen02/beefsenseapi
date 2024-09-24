package com.example.beefsenseapi.serviceinterfaces;
import com.example.beefsenseapi.entities.Role;
import java.util.List;

public interface IRoleService {
    void insert(Role Role);
    void delete(Long id);
    Role listId(Long id);
    List<Role> list();
}