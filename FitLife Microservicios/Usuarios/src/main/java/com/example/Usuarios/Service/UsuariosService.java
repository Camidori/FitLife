package com.example.Usuarios.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Usuarios.Model.Rol;
import com.example.Usuarios.Model.Usuarios;
import com.example.Usuarios.Repository.RolesRepository;
import com.example.Usuarios.Repository.UsuariosRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuariosService {
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private UsuariosRepository usuariosRepository;

    //metodo para obtener los usuarios
    public List<Usuarios> obteneUsuarios(){
        return usuariosRepository.findAll();
    }

    //metodo para crear un usuario
    public Usuarios crearUsuario(String username, String password, Long roleId){
        //VERIFICACION DEL ROL -- ES COMO UN IF
        Rol rol = rolesRepository.findById(roleId)
        .orElseThrow(()-> new RuntimeException("Rol no encontrado ID:"+ roleId));

        //SI PUEDO CREAR EL USUARIO NUEVO
        Usuarios nuevo = new Usuarios();
        nuevo.setUsername(username);
        nuevo.setPassword(password);
        nuevo.setRol(rol);
        return usuariosRepository.save(nuevo);
    }
    

}
