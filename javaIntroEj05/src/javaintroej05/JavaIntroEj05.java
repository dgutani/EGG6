/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroej05;

/**
 *
 * @author A308862
 */

import java.util.Scanner;
        
public class JavaIntroEj05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        boolean existe;
        double vardouble;
        String varcaracter;

        
        System.out.println("Ingresa varcaracter");
        varcaracter = leer.nextLine();
        
        System.out.println("Ingresar existe");
        existe = leer.nextBoolean();

        System.out.println("Ingresa vardoble");
        vardouble = leer.nextDouble();
       
        
        System.out.println(existe);
        
        System.out.println(vardouble);
        
        System.out.println(varcaracter);
        
    }
    
}
