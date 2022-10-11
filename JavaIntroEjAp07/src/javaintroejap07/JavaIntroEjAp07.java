/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap07;

import java.util.Scanner;


/**
 *
 * @author A308862
 * 
 * 
 * Crear un programa que pida una frase y si esa frase es igual a “eureka” el programa
 * pondrá un mensaje de Correcto, sino mostrará un mensaje de Incorrecto. Nota: investigar
 * la función equals() en Java.
 * 
 * 
 */
public class JavaIntroEjAp07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        String frase = "";
        
        System.out.println("Ingrese frase:");
        
        frase = lectura.nextLine();
        
        if (frase.toUpperCase().equals("EUREKA")) {
            System.out.println("CORRECTO");
        } else  {
            System.out.println("INCORRECTO");
        }
    }
    
}
