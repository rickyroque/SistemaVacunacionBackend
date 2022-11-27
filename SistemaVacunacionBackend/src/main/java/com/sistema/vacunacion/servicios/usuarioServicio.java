/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sistema.vacunacion.servicios;


import com.sistema.vacunacion.modelo.usuario;
import com.sistema.vacunacion.modelo.usuarioRol;
import java.util.List;

import java.util.Set;
/**
 *
 * @author Ricky Roque
 */

public interface usuarioServicio {
    /**
     * declaracion de los servicios crud para el usuario
     * @param usuario
     * @param usuarioRoles
     * @return 
     * @throws java.lang.Exception
    */
    public usuario guardarUsuario(usuario usuario, Set<usuarioRol> usuarioRoles) throws Exception;
    
    usuario actualizarUsuario(usuario usuario);
    
    public usuario obtenerUsuario(String username);
    
    public void eliminarUsuario(Long usuarioId);
    
    Set<usuario> obtenerUsuarios();
    
    List<usuario> listarEstadoVacunado();
    
    List<usuario> listarEstadoNoVacunado();
}
