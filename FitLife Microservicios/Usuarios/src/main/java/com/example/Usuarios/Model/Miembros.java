package com.example.Usuarios.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name ="miembros")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Miembros {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false, unique =true, length=50)
    private String usernameMiembro;
    
    @Column(nullable = false)
    private String passwordMiembro;

    
}
