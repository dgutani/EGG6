/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap17;
import java.util.Scanner;
/**
 *
 * @author A308862
 * 
17. Recorrer un vector de N enteros contabilizando cuántos números son de 1 dígito, cuántos
de 2 dígitos, etcétera (hasta 5 dígitos). * 
 */
public class JavaIntroEjAp17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        int elementos = 0;
        do {
            System.out.println("Ingrese cantidad de elementos del vector:");
            elementos = lectura.nextInt();
        } while (elementos <=0  );
        
        int [] vecVal = new int[elementos];        
        
        llenaVec(vecVal, elementos);
        PrintVec(vecVal, elementos);
        CuentaVec(vecVal, elementos);
    }
    
    public static void llenaVec( int [] vecVal, int elem ) {
        int i;
        for (i = 0; i < elem; i++) {
            vecVal[i]= (int) (Math.random() * 100000);
        }
    }
    
    public static void PrintVec( int [] vecVal, int elem ) {
        int i;
        System.out.println("Valores del vector:");
        for (i = 0; i < elem; i++) {
            System.out.print(i + ", " + vecVal[i] + " | ");
        }
    }
    
    
    public static void CuentaVec( int [] vecVal, int elem ) {
        int i;
        int [] cantVec = new int [5];
        
        System.out.println("\nCantidades de numeros por cantidad de cifras:");
         
        // recorre el vector contabilizando los numeros por cantidad de cifras
        for (i = 0; i < elem; i++) {
            
            if (vecVal[i] < 10 ) {
                cantVec[0]++;
            } else { if (vecVal[i] < 100 ) {
                        cantVec[1]++; 
                        } else { if (vecVal[i] < 1000 ) {
                                    cantVec[2]++;
                                    } else { if (vecVal[i] < 10000 ) {
                                            cantVec[3]++;
                                            } else { cantVec[4]++; 
                                                    }
                                            }
                                }
                    }
        }
        for (i = 0; i < 5; i++) {
            System.out.println("Cantidad de numeros de " + (i + 1) + " cifras : " + cantVec[i] );
        }
            
    }

    
}