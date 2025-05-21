package com.example.Usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Usuarios.Service.RolesService;
import com.example.Usuarios.Service.UsuariosService;

@RestController
@RequestMapping("/api/v1")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private RolesService rolesService;
}
