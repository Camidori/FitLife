package com.example.Usuarios.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Usuarios.Model.Rol;
import com.example.Usuarios.Repository.RolesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    //METODO PARA OBTENER TODOS LOS ROLES
    public List<Rol> obtenerRoles(){
        return rolesRepository.findAll();
    }
    
    //METODO PARA OBTENER UN ROLES POR SU ID
    public Rol obtenerRolPorId(long id){

        //EL ORELSETHROW ES COMO EL IFFFFFFF C:
        return rolesRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Rol no encontrado por el ID :c" +id));
    }
}
