/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap11;


import java.util.Scanner;

/**
 *
 * @author A308862
 * 
Realizar un programa que pida dos números enteros positivos por teclado y muestre por
pantalla el siguiente menú:
MENU
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
5. Salir
Elija opción:
El usuario deberá elegir una opción y el programa deberá mostrar el resultado por pantalla
y luego volver al menú. El programa deberá ejecutarse hasta que se elija la opción 5.
Tener en cuenta que, si el usuario selecciona la opción 5, en vez de salir del programa
directamente, se debe mostrar el siguiente mensaje de confirmación: ¿Está seguro que
desea salir del programa (S/N)? Si el usuario selecciona el carácter ‘S’ se sale del
programa, caso contrario se vuelve a mostrar el menú.
 * 
 */
public class JavaIntroEjAp11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        int num1 = 0;
        int num2 = 0;
        
        int opc = 0;
        String rta = "N";
        
        
        System.out.println("Ingrese num1:");
        num1 = lectura.nextInt();
        
        System.out.println("Ingrese num2:");
        num2 = lectura.nextInt();
        
        
        do {
            //System.out.print("\033[H\033[2J");
            //System.out.flush();
            System.out.println("MENU");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.println("Elija opcion:");
            
            opc = lectura.nextInt();
            if (opc == 5) {
                System.out.println("¿Está seguro que desea salir del programa (S/N)?");
                rta = lectura.next();
            }
        
        } while (!((opc == 5) && rta.toUpperCase().equals("S")));
    }    
}
