/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap05;

import java.util.Scanner;

/**
 *
 * @author A308862
 * 
 * Escribir un programa que lea un número entero por teclado y muestre por pantalla el
doble, el triple y la raíz cuadrada de ese número. Nota: investigar la función Math.sqrt().
 * 
 * 
 */
public class JavaIntroEjAp05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        double num1 = 0;
        
        System.out.println("Ingrese un numero entero:");
        num1 = lectura.nextInt();
        
        System.out.println("El doble de " + num1 + " es " + num1*2);
        System.out.println("El triple de " + num1 + " es " + num1*3);
        System.out.println("La raiz cuadrada de " + num1 + " es " +  Math.sqrt(num1) );
        
    }
    
}
