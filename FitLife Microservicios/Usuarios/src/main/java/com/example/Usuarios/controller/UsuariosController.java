package com.example.Usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Usuarios.Model.Rol;
import com.example.Usuarios.Model.Usuarios;
import com.example.Usuarios.Service.RolesService;
import com.example.Usuarios.Service.UsuariosService;

@RestController
@RequestMapping("/api/v1")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private RolesService rolesService;

    @GetMapping("/roles")
    public ResponseEntity<List<Rol>> getRoles(){
        List<Rol> roles = rolesService.obtenerRoles();
        //revisar lista si quedo vacia
        if(roles.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }

    //para consultar usuarios ENDPOINT
    @GetMapping("/users")
    public ResponseEntity<List<Usuarios>> getUsuarios(){
        List<Usuarios> users = usuariosService.obteneUsuarios();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    //ENDPOINT PARA CREAR USUARIO NUEVO
}
