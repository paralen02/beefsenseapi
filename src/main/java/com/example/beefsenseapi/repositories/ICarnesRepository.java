package com.example.beefsenseapi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.beefsenseapi.entities.*;
import java.util.List;

@Repository
public interface ICarnesRepository extends JpaRepository<Carnes, Integer> {
    @Query("SELECT c FROM Carnes c WHERE c.operarios_id.idOperarios = :operariosId")
    List<Carnes> findByOperariosId(@Param("operariosId") int operariosId); // Add this method
}
