/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.vacunacion.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Ricky Roque
 */
@Entity
@Table(name = "usuarios")
public class usuario implements UserDetails{
    
    //deficion de los datos para el usuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String username;/**username para acceso al sistema*/
    private String password;/**password para acceso al sistema*/
    private boolean enabled = true;/**define el estado activo o inactivo de un usuario*/
    
    /**
     * Informacion del usuario que ingresa el administrador, todos los campos son requeridos. 
     */
    @Column(name = "cedula", length = 10, nullable = false)//solo 10 digitos para la cedula
    private String cedula;
    @Column(name = "nombres", length = 50, nullable = false)
    private String nombres;
    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    /**
     * Informacion que el empleado completa luego de logearse, pueden ser vacios. 
     */
    private Date fechaNacimiento;
    private String domicilio;
    private String telefono;
    private String estadoVacunacion;
    /**
    declaracion de la relacion un usuario puede tener muchos roles  
    */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "usuario")
    @JsonIgnore
    private Set<usuarioRol> usuarioRoles = new HashSet<>();
    /**
    declaracion de la relacion un usuario puede tener muchos vacunas distintas  
    */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "vacuna")
    @JsonIgnore
    private Set<vacunaUsuario> vacunaUsuarios = new HashSet<>();
    
    public usuario(){

    }

    public usuario(Long id, String username, String password, String cedula, String nombres, String apellidos, String email, Date fechaNacimiento, String domicilio, String telefono, String estadoVacunacion) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estadoVacunacion = estadoVacunacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstadoVacunacion() {
        return estadoVacunacion;
    }

    public void setEstadoVacunacion(String estadoVacunacion) {
        this.estadoVacunacion = estadoVacunacion;
    }

    public Set<vacunaUsuario> getVacunaUsuarios() {
        return vacunaUsuarios;
    }

    public void setVacunaUsuarios(Set<vacunaUsuario> vacunaUsuarios) {
        this.vacunaUsuarios = vacunaUsuarios;
    }

    public Set<usuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<usuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    
        Set<Authority> autoridades = new HashSet<>();
        this.usuarioRoles.forEach(usuarioRol -> {
            autoridades.add(new Authority(usuarioRol.getRol().getNombre()));
        });
        return autoridades;
    
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

  
}
