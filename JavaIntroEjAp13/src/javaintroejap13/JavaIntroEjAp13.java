/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap13;


import java.util.Scanner;
/**
 *
 * @author A308862
 * 
 * 
 * Dibujar un cuadrado de N elementos por lado utilizando el carácter “*”. Por ejemplo, si el
    cuadrado tiene 4 elementos por lado se deberá dibujar lo siguiente:
 * 
 */
public class JavaIntroEjAp13 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        int lado = 0;
        int i, j = 0;
        String respuesta="";
        
	/// Ingreso de valor del lado del cuadrado a Dibujar
        do {
            System.out.println("Ingrese el lado del cuadrado : ");
            lado = lectura.nextInt();
            if (lado <= 0) {
		System.out.println("El valor debe ser mayor que cero!! (Enter para Continuar)");
		respuesta = lectura.nextLine();
            }
        } while (lado <=0);

	/// Ciclo de Dibujo del Cuadrado 
        for (i = 1; i <= lado; i++) {
            /// Determina si esta en la primera o ultima linea de asteriscos del cuadrado
            if ( i == 1 || i == lado ) {
		/// Escribe los asteriscos uno al lado del otro
                for ( j = 1; j <= lado; j++) {
                    System.out.print("* ");
                }
        	/// Salta la linea sin Imprimir 
		System.out.println("");
            } else { 
		///  Escribe los lados verticales
		for ( j = 1; j <= lado; j++) {
                    /// Escribe el asterisco cuando es el lado izquierdo o derecho
                    if ( j == 1 || j == lado ) {
			System.out.print("* ");
                    } else {
                    /// Escribe el espacio interior del cuadrado 
                        System.out.print("  ");
                    }
                }
                System.out.println("");
            }
        }
    }
}


