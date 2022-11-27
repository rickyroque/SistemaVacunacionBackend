/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sistema.vacunacion.servicios;

import com.sistema.vacunacion.modelo.vacuna;
import com.sistema.vacunacion.modelo.vacunaUsuario;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Ricky Roque
 */
public interface vacunaUsuarioServicio {
    
    public vacunaUsuario guardarVacunaUsuario(vacunaUsuario vacunaUsuario);
    
    vacunaUsuario actualizarVacunaUsuario(vacunaUsuario vacunaUsuario);
    
    public vacunaUsuario obtenerVacunaUsuario(Long vacunaUsuarioId);
    
    public void eliminarVacunaUsuario(Long vacunaUsuarioId);
    
    Set<vacunaUsuario> obtenerVacunasUsuarios();
    
    List<vacunaUsuario> listarTipoVacuna(vacuna vacuna);
    
    
}
