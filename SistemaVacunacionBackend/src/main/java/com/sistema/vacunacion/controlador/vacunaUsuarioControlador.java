/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.vacunacion.controlador;

import com.sistema.vacunacion.modelo.vacuna;
import com.sistema.vacunacion.modelo.vacunaUsuario;
import com.sistema.vacunacion.servicios.vacunaUsuarioServicio;
import java.util.List;
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
@RequestMapping("/vacunasUsuarios")//declara la peticion http para usuarios
@CrossOrigin("*")
public class vacunaUsuarioControlador {
    
    @Autowired
    private vacunaUsuarioServicio vacunaUsuarioServicio;

    /**
    * Metodo que guarda datos de la relacion entre vacunas y usuarios.
    * Se espera recibir el id de vacuna y el id de usuario a mas de los 
    * datos como fecha de vacunacion y el numero de dosis.
     * @param vacunaUsuario
     * @return 
    */
    @PostMapping("/")
    public ResponseEntity<vacunaUsuario> guardarVacunaUsuario(@RequestBody vacunaUsuario vacunaUsuario){
        return ResponseEntity.ok(vacunaUsuarioServicio.guardarVacunaUsuario(vacunaUsuario));
    }
    
    /**
    * Metodo que actualiza los datos de la relacion entre vacuna y usuario
     * @param vacunaUsuario
     * @return 
    */
    @PutMapping("/")
    public ResponseEntity<vacunaUsuario> actualizarVacunaUsuario(@RequestBody vacunaUsuario vacunaUsuario){
        return ResponseEntity.ok(vacunaUsuarioServicio.actualizarVacunaUsuario(vacunaUsuario));
    }
    /**
    * Metodo que obtiene datos la relacion vacunas-usuarios por la variable "vacunaUsuarioId"
     * @param vacunaUsuarioId
     * @return 
    */
    @GetMapping("/{vacunaUsuarioId}")
    public vacunaUsuario obtenerVacunaUsuario(@PathVariable("vacunaUsuarioId") Long vacunaUsuarioId){
        return vacunaUsuarioServicio.obtenerVacunaUsuario(vacunaUsuarioId);
    }
    /**
    * Metodo que elimina una vacuna por la variable "vacunaUsuarioId"
     * @param vacunaUsuarioId
    */
    @DeleteMapping("/{vacunaUsuarioId}")
    public void eliminarVacunaUsuario(@PathVariable("vacunaUsuarioId") Long vacunaUsuarioId){
        vacunaUsuarioServicio.eliminarVacunaUsuario(vacunaUsuarioId);
    }
     /**
    * Metodo que lista todos los resultados de la relacion vacunas-usuarios de la base de datos
     * @return 
    */
    @GetMapping("/")
    public ResponseEntity<?> listarVacunasUsuarios(){
        return ResponseEntity.ok(vacunaUsuarioServicio.obtenerVacunasUsuarios());
    }
    
    /**
    * filtro por tipo de vacuna, espera recibir el id de la vacuna a filtrar
     * @param vacunaId
     * @return 
    */
    @GetMapping("/tipo/{vacunaId}")
    public List<vacunaUsuario> listarTipoVacuna(@PathVariable("vacunaId") Long vacunaId){
        vacuna vacuna = new vacuna();
        vacuna.setVacunaId(vacunaId);
        return vacunaUsuarioServicio.listarTipoVacuna(vacuna);
    }
    
    
    
}
