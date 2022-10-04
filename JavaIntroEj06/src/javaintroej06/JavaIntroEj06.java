/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroej06;

/**
 *
 * @author A308862
 * 
 * Implementar un programa que le pida dos números enteros a usuario y determine si ambos o
 * alguno de ellos es mayor a 25.
 * 
 * 
 */

import java.util.Scanner;

public class JavaIntroEj06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        int num1;
        int num2;
        
        System.out.println("Ingrese el numero 1");
        num1 = leer.nextInt();
        
        System.out.println("Ingrese el numero 2");
        num2 = leer.nextInt();
        
        if ( num1 > 25 && num2 > 25 ) {
            System.out.println("Ambos valores son mayores a 25");
        } else if ( num1 > 25 && num2 <= 25 ) {
            System.out.println("Solo num1 es mayor a 25");
        } else if ( num1 <= 25 && num2 > 25 ) {
            System.out.println("Solo num2 es mayor a 25"); 
        } else System.out.println("Ambos valores son menores o iguales a 25");
    }
    
}
