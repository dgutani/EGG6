/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap15;
import java.util.Scanner;
/**
 *
 * @author A308862
 * 
 * Realizar un algoritmo que rellene un vector con los 100 primeros números enteros y los
 * muestre por pantalla en orden descendente.
 * 
 */
public class JavaIntroEjAp15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        double [] vecVal = new double[100];        
        
        llenaVec(vecVal);
        PrintVec(vecVal);
    }
    
    public static void llenaVec( double [] vecVal ) {
        int i;
        for (i = 0; i < 100; i++) {
            vecVal[i] = Math.random() * 100;
        }
        return;
    }
    
    public static void PrintVec( double [] vecVal ) {
        int i;
        for (i = 0; i < 100; i++) {
            System.out.println("Valor " + i + ":" + vecVal[i]);
        }
        return;
    }

    
}