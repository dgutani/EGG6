/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap10;


import java.util.Scanner;
/**
 *
 * @author A308862
 * Escriba un programa en el cual se ingrese un valor límite positivo, y a continuación solicite
 * números al usuario hasta que la suma de los números introducidos supere el límite inicial.
 * 
 */
public class JavaIntroEjAp10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        int valor = 0;
        int num = 0;
        int suma = 0;
        
        System.out.println("Ingrese un valor positivo:");
        valor = lectura.nextInt();
        
        
        do {
            System.out.println("Ingrese valor a sumar:");
            num = lectura.nextInt();
            
            suma = suma + num;
            
        } while (suma <= valor);
                
        System.out.println("La suma " + suma + " es mayor que " + valor);         
                
    }
    
}
