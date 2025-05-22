package com.example.Usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @PostMapping("/users")
    public ResponseEntity<?> crearUsuario(@RequestParam String username, @RequestParam String Password, @RequestParam Long rolId){
        try{
            //intento de crear usuario
            Usuarios nuevo =  usuariosService.crearUsuario(username, Password, rolId);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        }   catch (RuntimeException e){
            //si no crea el usuario, salta string del erro
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
