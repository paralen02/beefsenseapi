package com.example.beefsenseapi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.beefsenseapi.entities.Role;
import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE r.user.username = :username")
    List<Role> findRolesByUsername(@Param("username") String username);
}