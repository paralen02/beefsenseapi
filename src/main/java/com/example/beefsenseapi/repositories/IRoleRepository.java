package com.example.beefsenseapi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.beefsenseapi.entities.Role;
import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> { }