/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.vacunacion.controlador;


import com.sistema.vacunacion.configuraciones.JwtUtils;
import com.sistema.vacunacion.excepciones.UsuarioNotFoundException;
import com.sistema.vacunacion.modelo.JwtRequest;
import com.sistema.vacunacion.modelo.JwtResponse;
import com.sistema.vacunacion.modelo.usuario;
import com.sistema.vacunacion.servicios.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
/**
 *
 * @author Ricky Roque
 */
@RestController
@CrossOrigin("*")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    //generar token del usuario al momento de logearse
    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            autenticar(jwtRequest.getUsername(),jwtRequest.getPassword());//obtenemos el username y password ingresador por el usuario
        }catch (UsuarioNotFoundException  exception){
            exception.printStackTrace();
            throw new Exception("Usuario no encontrado");//Exception en caso de datos invalidos
        }

        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    //autenticar el username y password a travez del token obtenido 
    private void autenticar(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Credenciales invalidas " + e.getMessage());
        }
    }
    
    
    @GetMapping("/actual-usuario")
    public usuario obtenerUsuarioActual(Principal principal){
        return (usuario) this.userDetailsService.loadUserByUsername(principal.getName());
    }
    
}
