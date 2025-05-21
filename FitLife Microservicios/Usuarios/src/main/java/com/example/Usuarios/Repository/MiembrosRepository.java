package com.example.Usuarios.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Usuarios.Model.Miembros;

@Repository

public interface MiembrosRepository extends JpaRepository<Miembros, Long> {
    
}
