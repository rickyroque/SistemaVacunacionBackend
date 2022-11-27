/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.vacunacion.modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ricky Roque
 */
@Entity
public class vacunaUsuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vacunaUsuarioId; 

    //declaracion de la relacion en la tabla, muchos usuarios pueden tener un mismo rol
    @ManyToOne(fetch = FetchType.EAGER)
    private usuario usuario;
    //declaracion de la relacion en la tabla, muchos roles pueden puede elegir un usuario
    @ManyToOne
    private vacuna vacuna;
    
    private Date fechaVacunacion;
    private String numeroDosis;

    public vacunaUsuario() {
    }

    public vacunaUsuario(Long vacunaUsuarioId, usuario usuario, vacuna vacuna, Date fechaVacunacion, String numeroDosis) {
        this.vacunaUsuarioId = vacunaUsuarioId;
        this.usuario = usuario;
        this.vacuna = vacuna;
        this.fechaVacunacion = fechaVacunacion;
        this.numeroDosis = numeroDosis;
    }

    public Long getVacunaUsuarioId() {
        return vacunaUsuarioId;
    }

    public void setVacunaUsuarioId(Long vacunaUsuarioId) {
        this.vacunaUsuarioId = vacunaUsuarioId;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public Date getFechaVacunacion() {
        return fechaVacunacion;
    }

    public void setFechaVacunacion(Date fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }

    public String getNumeroDosis() {
        return numeroDosis;
    }

    public void setNumeroDosis(String numeroDosis) {
        this.numeroDosis = numeroDosis;
    }
    
    
    
}
