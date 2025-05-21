package com.example.Usuarios.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Usuarios.Model.Miembros;
import com.example.Usuarios.Repository.MiembrosRepository;

@Service
@Transactional
public class MiembrosService {
    @Autowired
    private MiembrosRepository miembrosRepository;

    //metodo para buscar los clientes
    public  List<Miembros> getMiembros(){
        return miembrosRepository.findAll();
    }

    //metodo para buscar miembro por ID
    public Miembros getMiembroId(Long id){
        return miembrosRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Cliente no encontrado por el id: "+id));
    }

    //metodo para guardar un cliente
    public Miembros saveMiembros(Miembros miembros){
        return miembrosRepository.save(miembros);
    }

}
