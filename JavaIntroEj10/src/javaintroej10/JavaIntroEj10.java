/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroej10;

/**
 *
 * @author A308862
 * 
 * Realizar un programa que lea 4 números (comprendidos entre 1 y 20) e imprima el número
   ingresado seguido de tantos asteriscos como indique su valor. Por ejemplo:
    5 *****
    3 ***
    11 ***********
    2 **
 * 
 */

import java.util.Scanner;

public class JavaIntroEj10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 
        Scanner leer = new Scanner(System.in);
        
        // Defino la variable num1 como byte porque el valor que debe ingresarse esta entre -127 y 127        
        byte num1;
        int subindice1;
        int j;
        
        // Defino bucle de 4 ciclos para carga del valor
        for (subindice1 = 0; subindice1 < 4; subindice1++) {
            num1 = 0;
            do
                 {
                    System.out.println("Ingrese numero:");
                    num1 = leer.nextByte();
                
            } while (num1 < 1 || num1 > 20 );
            
            System.out.print(num1 + " ");
            
            for (j = 0; j < num1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
}
