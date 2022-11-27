/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.vacunacion.servicios.impl;

import com.sistema.vacunacion.modelo.vacuna;
import com.sistema.vacunacion.repositorio.vacunaRepositorio;
import com.sistema.vacunacion.servicios.vacunaServicio;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ricky Roque
 */
@Service
public class vacunaServicioImpl implements vacunaServicio{

    @Autowired
    private vacunaRepositorio vacunaRepositorio;
    
    @Override
    public vacuna guardarVacuna(vacuna vacuna){
        return vacunaRepositorio.save(vacuna);
    }

    @Override
    public vacuna actualizarVacuna(vacuna vacuna) {
        return vacunaRepositorio.save(vacuna);
    }

    @Override
    public vacuna obtenerVacuna(Long vacunaId) {
        return vacunaRepositorio.findById(vacunaId).get();
    }

    @Override
    public void eliminarVacuna(Long vacunaId) {
        vacuna vacuna = new vacuna();
        vacuna.setVacunaId(vacunaId);
        vacunaRepositorio.delete(vacuna);
    }

    @Override
    public Set<vacuna> obtenerVacunas() {
        return new LinkedHashSet<>(vacunaRepositorio.findAll());
    }
    
}
