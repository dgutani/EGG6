/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroej12;

import java.util.Scanner;

/**
 *
 * @author A308862
 * Crea un procedimiento EsMultiplo que reciba los dos números pasados por el usuario, validando
 * que el primer numero múltiplo del segundo y e imprima si el primer numero es múltiplo del
 * segundo, sino informe que no lo son.
 */
public class JavaIntroEj12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        double num1 = 0;
        double num2 = 0;
        
        //Borrar Pantalla
            
        //Ingresar el primer numero
        System.out.println("Ingrese primer número : ");
            
        num1 = lectura.nextDouble();
            
        //Ingresar el segundo numero
        System.out.println("Ingrese segundo número : ");
            
        num2 = lectura.nextDouble();
            
        System.out.println("Los numeros ingresados son: " + num1 + " y " + num2);
        
        esMultiplo(num1, num2);
        
    }
        
        public static void esMultiplo(double num1, double num2) {
            
            if (num1 % num2 == 0) { 
                System.out.println("El número " + num1 + " es múltiplo de " + num2 );
                } else {
                System.out.println("El número " + num1 + " NO es múltiplo de " + num2 );
            }
    }
        
}