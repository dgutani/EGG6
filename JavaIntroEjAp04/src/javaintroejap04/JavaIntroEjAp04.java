/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap04;

import java.util.Scanner;

/**
 *
 * @author A308862
 * 
 * 4. Dada una cantidad de grados centígrados se debe mostrar su equivalente en grados
 * Fahrenheit. La fórmula correspondiente es: F = 32 + (9 * C / 5).
 * 
 */
public class JavaIntroEjAp04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        double tempCent = 0;
        double tempFahr = 0;
        
        
        System.out.println("Ingrese la temperatura en grados °C:");
        tempCent = lectura.nextDouble();
        tempFahr = 32 + (9 * tempCent / 5);
        
        System.out.println(tempCent + "°C equivale a " + tempFahr + "°F" );
        
    }
    
}
