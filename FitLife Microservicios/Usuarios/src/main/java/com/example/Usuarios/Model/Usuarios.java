package com.example.Usuarios.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // reconocen entidad JPA
@Table(name ="Usuarios") //crea la tabla en la bbdd
@Data //metodos setters, getters y tosting
@AllArgsConstructor // constructor con datos
@NoArgsConstructor // constructor vacio


public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //se genera solito
    private Long id;

    @Column(nullable = false, unique = true, length=50)
    private String username;

    @Column(nullable = false) //nulleable: no es opcional
    private String password;

    //para que usarios tengan el mismo rol

    @ManyToOne
    @JoinColumn(name = "rol_id") //columna foranea de rol
    @JsonIgnoreProperties ("users") //ignorar atributos users
    private Rol rol;
}
