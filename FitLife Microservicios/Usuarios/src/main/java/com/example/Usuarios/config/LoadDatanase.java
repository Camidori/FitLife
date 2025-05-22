package com.example.Usuarios.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Usuarios.Model.Rol;
import com.example.Usuarios.Model.Usuarios;
import com.example.Usuarios.Repository.RolesRepository;
import com.example.Usuarios.Repository.UsuariosRepository;

@Configuration
public class LoadDatanase {
    @Bean
    CommandLineRunner  initDatabase(RolesRepository rolRepo, UsuariosRepository usuarioRepo){
        return args ->{
         
            //SI NO HAY REGISTROS EN LA TABLA LOS INSERTO POR DEFECTO
           if(rolRepo.count()==0 && usuarioRepo.count()==0){
            //CARGAR LOS ROLES
            Rol admin = new Rol();
            admin.setNombre("Administrador");
            rolRepo.save(admin);

            Rol miembro = new Rol();
            miembro.setNombre("Miembro");
            rolRepo.save(miembro);

            Rol entrenador = new Rol();
            entrenador.setNombre("Entrenador");
            rolRepo.save(entrenador);

            usuarioRepo.save(new Usuarios(null,"Rodrigo","rojijo123",admin));
            usuarioRepo.save(new Usuarios(null,"Camila","Camuffin123.",entrenador));
            usuarioRepo.save(new Usuarios(null,"maikol","elreemplazante",miembro));
           } 
           else{
            System.out.println("Datos ya existentes. No se cargaron los datos");
           }
        };

    }
}
