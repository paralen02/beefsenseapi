package com.example.beefsenseapi.serviceinterfaces;
import com.example.beefsenseapi.dtos.UsersDTO;
import com.example.beefsenseapi.entities.Users;
import java.util.List;

public interface IUsersService {
    void insert(Users Users);
    void delete(Long id);
    Users listId(Long id);
    List<Users> list();
    void insertAndAssignRole(Users user, String roleName);
    Users findByUsername(String username);
    void patchUser(Long id, UsersDTO dto); // New method
}