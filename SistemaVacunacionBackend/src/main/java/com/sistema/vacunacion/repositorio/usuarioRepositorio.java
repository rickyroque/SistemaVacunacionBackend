/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sistema.vacunacion.repositorio;


import com.sistema.vacunacion.modelo.usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Ricky Roque
 */
public interface usuarioRepositorio extends JpaRepository<usuario,Long> {
    
    //declaracion del metodo para buscar por nombre de usuario
    public usuario findByUsername(String username);
    
    List<usuario> findByEstadoVacunacion(String estadoVacunacion);
    
    
}
