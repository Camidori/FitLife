package com.example.Usuarios.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Usuarios.Model.Entrenador;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long>{

}
