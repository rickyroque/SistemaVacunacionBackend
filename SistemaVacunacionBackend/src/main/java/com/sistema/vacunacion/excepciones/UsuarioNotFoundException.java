/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.vacunacion.excepciones;

/**
 *
 * @author Ricky Roque
 */
public class UsuarioNotFoundException extends Exception{
    
    public UsuarioNotFoundException(){
        super("Username Incorrecto, intente de nuevo");
    }

    public UsuarioNotFoundException(String mensaje){
        super(mensaje);
    }
    
}
