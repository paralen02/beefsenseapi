package com.example.beefsenseapi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.beefsenseapi.entities.*;
import java.util.List;

@Repository
public interface IClasificacionesRepository extends JpaRepository<Clasificaciones, Integer> { }
