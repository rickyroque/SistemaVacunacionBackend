/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sistema.vacunacion.repositorio;

import com.sistema.vacunacion.modelo.vacuna;
import com.sistema.vacunacion.modelo.vacunaUsuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ricky Roque
 */
public interface vacunaUsuarioRepositorio extends JpaRepository<vacunaUsuario,Long>{
     
    List<vacunaUsuario> findByVacuna(vacuna vacuna);
    
    
}
