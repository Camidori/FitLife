package com.example.Usuarios.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Usuarios.Model.Rol;

@Repository

public interface RolesRepository extends JpaRepository<Rol, Long> {

}
