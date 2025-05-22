package com.example.Usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Usuarios.Model.Miembros;
import com.example.Usuarios.Service.MiembrosService;

@RestController
@RequestMapping("/api/v1/miembros")
public class MiembrosController {
    @Autowired
    private MiembrosService miembrosService;

    //ENDPOINT PARA BUSCAR TODOS LOS MIEMBROS
    @GetMapping
    public ResponseEntity<List<Miembros>> obtenerMiembros(){
        List<Miembros> lista = miembrosService.getMiembros();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    //ENDPOINT PARA OBTENER MIEMBRO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Miembros> obtenerMiembroId(@PathVariable Long id){
        try{
            Miembros nuevo = miembrosService.getMiembroId(id);
            return ResponseEntity.ok(nuevo);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    //ENDPOINT PARA CREAR NUEVO MIEMBRO
    @PostMapping
    public ResponseEntity<Miembros> guardarMiembro(@RequestBody Miembros miembros){
        return ResponseEntity.status(0).body(miembrosService.saveMiembros(miembros));
    }
}
