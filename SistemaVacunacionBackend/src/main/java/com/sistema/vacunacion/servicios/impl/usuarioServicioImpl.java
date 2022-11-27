/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.vacunacion.servicios.impl;

import com.sistema.vacunacion.excepciones.UsuarioFoundException;
import com.sistema.vacunacion.modelo.*;
import com.sistema.vacunacion.repositorio.*;
import com.sistema.vacunacion.servicios.*;
import java.util.LinkedHashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 *
 * @author Ricky Roque
 */
@Service
public class usuarioServicioImpl implements usuarioServicio{
    
    @Autowired
    private usuarioRepositorio usuarioRepositorio;

    @Autowired
    private rolRepositorio rolRepositorio;

    @Override
    public usuario guardarUsuario(usuario usuario, Set<usuarioRol> usuarioRoles) throws Exception {
        usuario usuarioLocal = usuarioRepositorio.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya esta presente");
        }
        else{
            for(usuarioRol usuarioRol:usuarioRoles){
                rolRepositorio.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepositorio.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public usuario actualizarUsuario(usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
    
    @Override
    public usuario obtenerUsuario(String username) {
        return usuarioRepositorio.findByUsername(username);
    }
    
    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepositorio.deleteById(usuarioId);
    }
    
    @Override
    public Set<usuario> obtenerUsuarios() {
        return new LinkedHashSet<>(usuarioRepositorio.findAll());
    }
    
    @Override
    public List<usuario> listarEstadoVacunado() {
        return usuarioRepositorio.findByEstadoVacunacion("vacunado");
    }
    
    @Override
    public List<usuario> listarEstadoNoVacunado() {
        return usuarioRepositorio.findByEstadoVacunacion("novacunado");
    }
    
    
}
