/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.vacunacion.controlador;

import com.sistema.vacunacion.modelo.rol;
import com.sistema.vacunacion.modelo.usuario;
import com.sistema.vacunacion.modelo.usuarioRol;
import com.sistema.vacunacion.servicios.usuarioServicio;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
@RequestMapping("/usuarios")//declara la peticion http para usuarios
@CrossOrigin("*")
public class usuarioControlador {
    
    @Autowired
    private usuarioServicio usuarioServicio;
    
    /**
     * funcion para generar contraseñas aleatorias
     * @param len
     * @return 
     */
    public static String generarPassword(int len){
        // Rango ASCII – alfanumérico (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        // cada iteración del bucle elige aleatoriamente un carácter del dado
        // rango ASCII y lo agrega a la instancia `StringBuilder`
        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
    
    /**
    * Se decalara un metodo POST para guardar, el usuario administrador registra empleados 
    * se guarda: cedula, nombres, apellidos, email; username y password se generan y guardan 
    * en la base de datos a partir de los datos ingresados.Se le añade el rol de empleado por defecto.
     * @param usuario 
     * @return  
     * @throws java.lang.Exception 
    */
    @PostMapping("/")
    public usuario guardarUsuario(@RequestBody usuario usuario) throws Exception{
        
        Set<usuarioRol> usuarioRoles = new HashSet<>();//se declara el objeto usuarioRoles para la tabla
        
        rol rol = new rol();
        rol.setRolId(2L);
        rol.setNombre("empleado");
            
        usuario.setUsername(usuario.getCedula());//se toma la cedula ingresada como nombre de usuario
        usuario.setPassword(generarPassword(10));//se define un tamaño de 10 caracteres para la contraseña
        
        usuarioRol usuarioRol = new usuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);
        usuarioRoles.add(usuarioRol);
        return usuarioServicio.guardarUsuario(usuario,usuarioRoles);
    }
    
    /**
    * Metodo que actualiza los datos del empleado
     * @param usuario
     * @return 
    */
    @PutMapping("/")
    public usuario actualizarUsuario(@RequestBody usuario usuario){
        return usuarioServicio.actualizarUsuario(usuario);
    }
    /**
    * Metodo que obtiene datos de un usuario por la variable "username"
     * @param username
     * @return 
    */
    @GetMapping("/{username}")
    public usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioServicio.obtenerUsuario(username);
    }
    /**
    * Metodo que elimina un usuario por la variable "usuarioId"
     * @param usuarioId
    */
    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioServicio.eliminarUsuario(usuarioId);
    }
     /**
    * Metodo que lista todos los usuarios de la base de datos
     * @return 
    */
    @GetMapping("/")
    public ResponseEntity<?> listarUsuarios(){
        return ResponseEntity.ok(usuarioServicio.obtenerUsuarios());
    }
    
    /**
    * filtro por estado de vacunacion: vacunado
     * @return 
    */
    @GetMapping("/vacunado/")
    public List<usuario> listarEstadoVacunado(){
        return usuarioServicio.listarEstadoVacunado();
    }
    /**
    * filtro por estado de vacunacion: no vacunado
     * @return 
    */
    @GetMapping("/novacunado/")
    public List<usuario> listarEstadoNoVacunado(){
        return usuarioServicio.listarEstadoNoVacunado();
    }
    
    
}
