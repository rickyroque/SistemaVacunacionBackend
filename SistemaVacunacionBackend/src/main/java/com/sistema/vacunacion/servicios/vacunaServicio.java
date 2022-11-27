/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sistema.vacunacion.servicios;

import com.sistema.vacunacion.modelo.vacuna;
import java.util.Set;

/**
 *
 * @author Ricky Roque
 */
public interface vacunaServicio {
    
    public vacuna guardarVacuna(vacuna vacuna);
    
    vacuna actualizarVacuna(vacuna vacuna);
    
    public vacuna obtenerVacuna(Long vacunaId);
    
    public void eliminarVacuna(Long vacunaId);
    
    Set<vacuna> obtenerVacunas();
    
}
