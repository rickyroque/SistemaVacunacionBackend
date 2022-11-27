/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.vacunacion.modelo;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ricky Roque
 */
@Entity
@Table(name = "roles")
public class rol {
    
    //definicion de los datos para el rol
    @Id
    private Long rolId; 
    private String nombre;
    
    //declaracion de la relacion, un rol puede estar en muchos usuarios
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "rol")
    private Set<usuarioRol> usuarioRoles = new HashSet<>();
    
    public rol(){

    }

    public rol(Long rolId, String nombre) {
        this.rolId = rolId;
        this.nombre = nombre;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<usuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<usuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }
    
    
    
    
}
