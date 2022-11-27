/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.vacunacion.controlador;

import com.sistema.vacunacion.modelo.vacuna;
import com.sistema.vacunacion.servicios.vacunaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ricky Roque
 */
@RestController
@RequestMapping("/vacunas")//declara la peticion http para usuarios
@CrossOrigin("*")
public class vacunaControlador {
    
    @Autowired
    private vacunaServicio vacunaServicio;
    
    /**
    * Metodo que guarda los datos de la vacuna
     * @param vacuna
     * @return 
    */
    @PostMapping("/")
    public vacuna guardarVacuna(@RequestBody vacuna vacuna){
        return vacunaServicio.guardarVacuna(vacuna);
    }
    
    /**
    * Metodo que actualiza los datos de una vacuna
     * @param vacuna
     * @return 
    */
    @PutMapping("/")
    public vacuna actualizarVacuna(@RequestBody vacuna vacuna){
        return vacunaServicio.actualizarVacuna(vacuna);
    }
    /**
    * Metodo que obtiene datos de una vacuna por la variable "vacunaId"
     * @param vacunaId
     * @return 
    */
    @GetMapping("/{vacunaId}")
    public vacuna obtenerVacuna(@PathVariable("vacunaId") Long vacunaId){
        return vacunaServicio.obtenerVacuna(vacunaId);
    }
    /**
    * Metodo que elimina una vacuna por la variable "vacunaId"
     * @param vacunaId
    */
    @DeleteMapping("/{vacunaId}")
    public void eliminarVacuna(@PathVariable("vacunaId") Long vacunaId){
        vacunaServicio.eliminarVacuna(vacunaId);
    }
     /**
    * Metodo que lista todos las vacunas de la base de datos
     * @return 
    */
    @GetMapping("/")
    public ResponseEntity<?> listarVacunas(){
        return ResponseEntity.ok(vacunaServicio.obtenerVacunas());
    }
    
    
}
