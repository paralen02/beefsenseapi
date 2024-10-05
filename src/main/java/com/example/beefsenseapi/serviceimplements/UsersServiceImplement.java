package com.example.beefsenseapi.serviceimplements;
import com.example.beefsenseapi.dtos.UsersDTO;
import com.example.beefsenseapi.security.WebSecurityConfig;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import com.example.beefsenseapi.repositories.UserRepository;
import com.example.beefsenseapi.serviceinterfaces.IUsersService;
import com.example.beefsenseapi.entities.Users;
import java.util.List;

@Service
public class UsersServiceImplement implements IUsersService {
    @Autowired
    private UserRepository myRepository;

    // Add an item to table
    @Override
    public void insert(Users Users) {
        myRepository.save(Users);
    }

    @Override
    @Transactional
    public void insertAndAssignRole(Users user, String roleName) {
        // Set the password to the encoded username
        user.setPassword(WebSecurityConfig.passwordEncoder().encode(user.getUsername()));
        // Guardar el usuario y obtener el ID generado
        Long userId = myRepository.save(user).getId();
        // Asignar el rol al usuario
        myRepository.insRol(roleName, userId);
    }

    // Delete an item by ID on table
    @Override
    @Transactional
    public void delete(Long idUsers) {
        myRepository.deleteRolesByUserId(idUsers);
        myRepository.deleteById(idUsers);
    }

    // Retrieve an items by ID from table
    @Override
    public Users listId(Long idUsers) {
        return myRepository.findById(idUsers).orElse(new Users());
    }

    // Retrieve all items from table
    @Override
    public List<Users> list() {
        return myRepository.findAll();
    }

    @Override
    public Users findByUsername(String username) {
        return myRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void patchUser(Long id, UsersDTO dto) {
        Users user = myRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        if (dto.getUsername() != null) {
            user.setUsername(dto.getUsername());
            user.setPassword(WebSecurityConfig.passwordEncoder().encode(dto.getUsername()));
        }

        if (dto.getPassword() != null) {
            user.setPassword(WebSecurityConfig.passwordEncoder().encode(dto.getPassword()));
        }

        user.setEnabled(dto.isEnabled());
        myRepository.save(user);
    }
}
