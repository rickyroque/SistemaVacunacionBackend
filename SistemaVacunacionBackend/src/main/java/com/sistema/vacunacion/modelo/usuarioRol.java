/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.vacunacion.modelo;

import javax.persistence.*;

/**
 *
 * @author Ricky Roque
 */
@Entity
public class usuarioRol {
    
    //deficion de los datos para la relacion entre usuarios y roles
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioRolId; 

    //declaracion de la relacion en la tabla, muchos usuarios pueden tener un mismo rol
    @ManyToOne(fetch = FetchType.EAGER)
    private usuario usuario;
    //declaracion de la relacion en la tabla, muchos roles pueden puede elegir un usuario
    @ManyToOne
    private rol rol;

    public Long getUsuarioRolId() {
        return usuarioRolId;
    }

    public void setUsuarioRolId(Long usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public rol getRol() {
        return rol;
    }

    public void setRol(rol rol) {
        this.rol = rol;
    }
    
}
