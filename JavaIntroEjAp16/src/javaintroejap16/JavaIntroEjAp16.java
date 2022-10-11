/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap16;
import java.util.Scanner;
/**
 *
 * @author A308862
 * 
Realizar un algoritmo que rellene un vector de tamaño N con valores aleatorios y le pida al
usuario un numero a buscar en el vector. El programa mostrará donde se encuentra el
numero y si se encuentra repetido
 * 
 */
public class JavaIntroEjAp16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        int elementos = 0;
        int numero = 0;
        do {
            System.out.println("Ingrese cantidad de elementos del vector:");
            elementos = lectura.nextInt();
            
            System.out.println("Ingrese numero a buscar:");
            numero = lectura.nextInt();
            
        } while (elementos <=0 || numero <=0 );
        
        
        int [] vecVal = new int[elementos];        
        
        llenaVec(vecVal, elementos);
        PrintVec(vecVal, elementos);
        buscaVec(vecVal, elementos, numero);
    }
    
    public static void llenaVec( int [] vecVal, int elem ) {
        int i;
        for (i = 0; i < elem; i++) {
            vecVal[i]= (int) (Math.random() * 100);
        }
    }
    
    public static void PrintVec( int [] vecVal, int elem ) {
        int i;
        System.out.println("Valores del vector:");
        for (i = 0; i < elem; i++) {
            System.out.print(i + ", " + vecVal[i]);
        }
    }
    
    
    public static void buscaVec( int [] vecVal, int elem, int num1 ) {
        int i;
        
        System.out.println("\nEl valor " + num1 + " fue encontrado en los siguientes elementos del vector:");
         
        // recorre el vector en busca del / los elementos que coinciden con el valor buscado
        for (i = 0; i < elem; i++) {
            if ( vecVal[i] == num1 ) {
                System.out.print( i + " , " );
            }
        }
    }

    
}