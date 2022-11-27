/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.vacunacion.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Ricky Roque
 */
@Entity
@Table(name = "vacunas")
public class vacuna {
    
    @Id
    private Long vacunaId; 
    private String nombre;
    
    /**
     * declaracion de la relacion un tipo de vacuna la pueden tener muchos usuarios
    */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "vacuna")
    @JsonIgnore
    private Set<vacunaUsuario>  vacunaUsuarios = new HashSet<>();

    public vacuna() {
    }

    public vacuna(Long vacunaId, String nombre) {
        this.vacunaId = vacunaId;
        this.nombre = nombre;
    }

    public Long getVacunaId() {
        return vacunaId;
    }

    public void setVacunaId(Long vacunaId) {
        this.vacunaId = vacunaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<vacunaUsuario> getVacunaUsuarios() {
        return vacunaUsuarios;
    }

    public void setVacunaUsuarios(Set<vacunaUsuario> vacunaUsuarios) {
        this.vacunaUsuarios = vacunaUsuarios;
    }

    
}
