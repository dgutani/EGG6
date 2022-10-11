/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap02;

import java.util.Scanner;

/**
 *
 * @author A308862
 * 
 * Escribir un programa que pida tu nombre, lo guarde en una variable y lo muestre por
 * pantalla.
 */
public class JavaIntroEjAp02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lectura = new Scanner(System.in);
        String nombre = " ";
        
        System.out.println("Ingrese su nombre:");
        nombre = lectura.nextLine();
        
        System.out.println("El nombre ingresado es : " + nombre);
        
    }
    
}

