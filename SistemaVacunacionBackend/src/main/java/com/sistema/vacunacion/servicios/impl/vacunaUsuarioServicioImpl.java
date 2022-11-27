/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.vacunacion.servicios.impl;

import com.sistema.vacunacion.modelo.vacuna;
import com.sistema.vacunacion.modelo.vacunaUsuario;
import com.sistema.vacunacion.repositorio.vacunaUsuarioRepositorio;
import com.sistema.vacunacion.servicios.vacunaUsuarioServicio;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ricky Roque
 */
@Service
public class vacunaUsuarioServicioImpl implements vacunaUsuarioServicio{
    
    @Autowired
    private vacunaUsuarioRepositorio vacunaUsuarioRepositorio;
    
    @Override
    public vacunaUsuario guardarVacunaUsuario(vacunaUsuario vacunaUsuario){
        return vacunaUsuarioRepositorio.save(vacunaUsuario);
    }

    @Override
    public vacunaUsuario actualizarVacunaUsuario(vacunaUsuario vacunaUsuario) {
        return vacunaUsuarioRepositorio.save(vacunaUsuario);
    }

    @Override
    public vacunaUsuario obtenerVacunaUsuario(Long vacunaUsuarioId) {
        return vacunaUsuarioRepositorio.findById(vacunaUsuarioId).get();
    }

    @Override
    public void eliminarVacunaUsuario(Long vacunaUsuarioId) {
        vacunaUsuario vacunaUsuario = new vacunaUsuario();
        vacunaUsuario.setVacunaUsuarioId(vacunaUsuarioId);
        vacunaUsuarioRepositorio.delete(vacunaUsuario);
    }

    @Override
    public Set<vacunaUsuario> obtenerVacunasUsuarios() {
        return new LinkedHashSet<>(vacunaUsuarioRepositorio.findAll());
    }

    @Override
    public List<vacunaUsuario> listarTipoVacuna(vacuna vacuna) {
        return vacunaUsuarioRepositorio.findByVacuna(vacuna);
    }

    
     
}

