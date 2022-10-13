/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap20;


import java.util.Scanner;
/**
 *20. Un cuadrado mágico 3 x 3 es una matriz 3 x 3 formada por números del 1 al 9 donde la
suma de sus filas, sus columnas y sus diagonales son idénticas. Crear un programa que
permita introducir un cuadrado por teclado y determine si este cuadrado es mágico o no.
El programa deberá comprobar que los números introducidos son correctos, es decir,
están entre el 1 y el 9.
 * @author A308862
 */
public class JavaIntroEjAp20 {
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        // Defino Matriz de 3x3
        int elementos = 0;

        do {
            System.out.println("Cantidad de elementos de la Magic Matrix:");
            elementos=lectura.nextInt();
        } while (elementos < 1 || elementos > 10);

        int [][] matriz = new int [elementos][elementos];
        
        prcLlenaMatriz(matriz, elementos, elementos);	
	
	prcMuestraMatriz(matriz, elementos, elementos);
        
    }
    
    
        
    
//// Carga de matriz
    public static void prcLlenaMatriz(int [][] mat, int  fil, int col) {
        Scanner leer = new Scanner(System.in);
        System.out.println("MAGIC MATRIX - Ingresando valores");
        for (int i= 0; i < fil;i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Elemento " + i + " , " + j + ":");
                mat[i][j]= leer.nextInt();
            }
        }
    }
    
    public static void prcMuestraMatriz(int [][] mat, int fil, int col) {
        boolean magica=true;
        int [] sumafil = new int [fil];
        int [] sumacol = new int [col];
        int [] sumadiag = new int [2];
    /// Inicializa vectores de control de sumas
       for (int i = 0; i < fil - 1 ; i++) {
            sumafil[i]=0;
        }
       for (int i = 0; i < col - 1 ; i++) {
            sumacol[i]=0;
        }
       for (int i = 0; i < 2 ; i++) {
            sumadiag[i]=0;
        }
        System.out.println("Matriz Generada");
        for (int i = 0; i < fil; i++) {
	//// Salto de fila
            System.out.println("");
            for (int j = 0; j < col; j++) {
		//// Muestro el valor de la Matriz
		System.out.print(mat[i][j] + "|" );
                //// Suma fila y columna			
		sumafil[i]=sumafil[i] + mat[i][j];
		sumacol[j]=sumacol[j] + mat[i][j];
		//// Si ambos subindices son iguales estoy en un elemento de la diagonal 1
		if (i == j) {
                    sumadiag[0] = sumadiag[0] + mat[i][j];
                }
		//// Si la suma de ambos subindices es igual al tamaño de la matriz cuadrada estoy en un elemento de la diagonal 2
		if (i + j == col - 1 ) {
                    sumadiag[1] = sumadiag[1] + mat[i][j];
                }
            }
        }
	System.out.println(" ");
	System.out.print("Las sumas de las filas de la matriz son: ");
	
	for (int i=0; i < fil; i++ ) {
            System.out.print( sumafil[i] + " | " );
            
        }
	
        System.out.println("");
        System.out.print("Las sumas de las columnas de la matriz son: ");

        for (int j = 0; j < col; j++) {
            System.out.print(sumacol[j] + " | ");
            
        }
        
        System.out.println("");
        System.out.println("Las sumas de las diagonales de la matriz son: ");
        
        for (int j = 0; j < 2; j++) {
            System.out.print(sumadiag[j] + " | ");
        }
	
	magica=true;
	
	for (int i = 0; i < fil - 1; i++) {
            if ( i < fil - 1 ) {
		if ( sumafil[i] != sumafil[i + 1]) {
                    magica=false;
                }
		if ( sumacol[i] != sumacol[i + 1]) {
                    magica=false;
                }
            }
        }
	
	if ( sumadiag[0] != sumadiag[1] ) {
            magica=false;
        }
	
	System.out.println("");
	
	if (magica) {
            System.out.println("La matriz es MAGICA!!!!!!!!");
        } else {
            System.out.println("La matriz NO ES MAGICA");
        }
    }
}
    
			
			
	
	
	
