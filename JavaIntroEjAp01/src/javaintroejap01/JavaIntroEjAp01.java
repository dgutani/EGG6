/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap01;


/**
 *
 * @author A308862
 * 1. Escribir un programa que pida dos números enteros por teclado y calcule la suma de los
 * dos. El programa deberá después mostrar el resultado de la suma
 */
import java.util.Scanner;

public class JavaIntroEjAp01 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        double num1 = 0;
        double num2 = 0;
        double suma = 0;
        
        do {
            System.out.println("Ingrese num1:");
            num1 = lectura.nextDouble();
            System.out.println("Ingrese num2:");
            num2 = lectura.nextDouble();
            
        } while (num1 == 0 || num2 == 0 );
        
        suma = num1 + num2;
        
        System.out.println("La suma de num1 + num2 es :" + suma);
        
    }
    
}
