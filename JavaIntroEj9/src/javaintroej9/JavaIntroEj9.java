/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroej9;

/**
 *
 * @author A308862
 * 
 * 
 * Escriba un programa que lea 20 números. Si el número leído es igual a cero se debe salir del
    bucle y mostrar el mensaje "Se capturó el numero cero". El programa deberá calcular y mostrar el
    resultado de la suma de los números leídos, pero si el número es negativo no debe sumarse.
    Nota: recordar el uso de la sentencia break.
 */


import java.util.Scanner;

public class JavaIntroEj9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        int contador = 0;
        double numero = 0;
        double sumador = 0;
        
        do {
            System.out.println("Ingrese Numero:");
            numero = leer.nextDouble();
            
            if (numero == 0) { 
                System.out.println("Se capturó el numero 0");
                contador = 99;
                break;
            } else if (numero > 0) {
                sumador = sumador+numero;
            }
            contador++;
        } while (contador < 20);
            
        if (contador < 99) {
            System.out.println("La suma de los numero" + sumador);
        }
            
    }
    
}
