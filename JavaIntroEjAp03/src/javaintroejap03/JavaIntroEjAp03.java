/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap03;

import java.util.Scanner;
/**
 *
 * @author A308862
 * Escribir un programa que pida una frase y la muestre toda en mayúsculas y después toda
 * en minúsculas. Nota: investigar la función toUpperCase() y toLowerCase() en Java.
 */
public class JavaIntroEjAp03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner lectura = new Scanner(System.in);        
    
    String frase = "";
    String fraseM = "";
    String frasem = "";
        
        System.out.println("Ingrese una frase con mayusculas y minusculas:");
        frase = lectura.nextLine();
        
        System.out.println("Frase en mayusculas:" + frase.toUpperCase());
        System.out.println("Frase en mayusculas:" + frase.toLowerCase());
        
    }
    
}
