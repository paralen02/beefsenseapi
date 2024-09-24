package com.example.beefsenseapi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.beefsenseapi.entities.*;
import java.util.List;

@Repository
public interface IOperariosRepository extends JpaRepository<Operarios, Integer> {
    @Query(value = "SELECT c.* FROM operarios c\n" +
            "JOIN users u ON c.users_id = u.id\n" +
            "WHERE u.username = :username", nativeQuery= true)
    Operarios findByUsername(@Param("username") String username);
}
