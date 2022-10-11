/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap06;

import java.util.Scanner;

/**
 *
 * @author A308862
 * 
 * 6. Crear un programa que dado un numero determine si es par o impar.
 * 
 * 
 */
public class JavaIntroEjAp06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        int num1 = 0;
        
        System.out.println("Ingrese un numero:");
        num1 = lectura.nextInt();
        
        if (num1 % 2 == 0) {
            System.out.println("El numero " + num1 + " es par");
        } else         {
            System.out.println("El numero " + num1 + " es impar");
        }
        
    }
    
}
