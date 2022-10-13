/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap21;

/**
 *Dadas dos matrices cuadradas de números enteros, la matriz M de 10x10 y la matriz P de
3x3, se solicita escribir un programa en el cual se compruebe si la matriz P está contenida
dentro de la matriz M. Para ello se debe verificar si entre todas las submatrices de 3x3 que
se pueden formar en la matriz M, desplazándose por filas o columnas, existe al menos una
que coincida con la matriz P. En ese caso, el programa debe indicar la fila y la columna de
la matriz M en la cual empieza el primer elemento de la submatriz P.
 * @author A308862
 */


import java.util.Scanner;


public class JavaIntroEjAp21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        int [][] matrizM = new int [5][5];
        int [][] matrizP = new int [3][3];

        System.out.println("SUB MATRIZ CONTENIDA - Ingresando valores");

        
        prcLlenaMatriz(matrizM, "M", 5, 5);	
        prcLlenaMatriz(matrizP, "P",  3,  3);	
	
	prcMuestraMatriz(matrizM, "M", 5, 5);	
	prcMuestraMatriz(matrizP, "P",  3,  3);	
        
        prcBuscaSubMatriz(matrizM, 5, 5, matrizP, 3, 3);
        
        
        
    }
    
    
        
    
//// Carga de matriz
    public static void prcLlenaMatriz(int [][] mat, String letra, int  fil, int col) {
        Scanner leer = new Scanner(System.in);
        for (int i= 0; i < fil;i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Elemento Matriz ( " + letra +  ") " + i + " , " + j + " de " + fil + "filas/" + col + " columnas :");
                mat[i][j]= leer.nextInt();
            }
        }
    }        
        

    public static void prcMuestraMatriz(int [][] mat, String letra, int fil, int col) {
        System.out.println("");
        
        System.out.println("Matriz ( " + letra + " )Generada");
        for (int i = 0; i < fil; i++) {
	//// Salto de fila
            System.out.println("");
            for (int j = 0; j < col; j++) {
		//// Muestro el valor de la Matriz
		System.out.print(mat[i][j] + "|" );
            }
        }
    }
        
    public static void prcBuscaSubMatriz(int [][] matM,  int filM, int colM, int [][] matP,  int filP, int colP) {
        
        String matPosicion[][] = new String [3][3];
        
        for (int i = 0; i < filM - (filP-1); i++) {
	//// Ciclos de busqueda
            for (int j = 0; j < colM - (colP-1); j++) {
                // Compara valores de M con los valores de la primera fila de la matriz P
                if ( matM[i][j]==matP[0][0] && matM[i][(j+1)]==matP[0][1] && matM[i][(j+2)]==matP[0][2]) {
                    if ( matM[i+1][j]==matP[1][0] && matM[i+1][(j+1)]==matP[1][1] && matM[i+1][(j+2)]==matP[1][2]) {
                        if ( matM[i+2][j]==matP[2][0] && matM[i+2][(j+1)]==matP[2][1] && matM[i+2][(j+2)]==matP[2][2]) {
                            System.out.println("Submatriz P encontrada en la Matriz M en:");
                            System.out.println((i)     + "," + j + "|" + (i)     + "," + (j + 1) + "|" + (i)     + "," + (j + 2));
                            System.out.println((i + 1) + "," + j + "|" + (i + 1) + "," + (j + 1) + "|" + (i + 1) + "," + (j + 2));
                            System.out.println((i + 2) + "," + j + "|" + (i + 2) + "," + (j + 1) + "|" + (i + 2) + "," + (j + 2));
                        }
                    }
                }
            }
        }
    }
    
    
}
