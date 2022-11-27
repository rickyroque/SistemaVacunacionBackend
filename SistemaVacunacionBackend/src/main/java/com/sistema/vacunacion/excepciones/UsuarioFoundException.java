/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.vacunacion.excepciones;

/**
 *
 * @author Ricky Roque
 */
public class UsuarioFoundException extends Exception{
    
    public UsuarioFoundException(){
        super("El username ya existe, elija otro");
    }

    public UsuarioFoundException(String mensaje){
        super(mensaje);
    }
    
}
