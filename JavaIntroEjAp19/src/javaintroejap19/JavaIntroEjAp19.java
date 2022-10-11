/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap19;
import java.util.Scanner;
/**
 *
 * @author A308862
 * 
18. Realizar un programa que rellene un matriz de 4 x 4 de valores aleatorios y muestre la
traspuesta de la matriz. La matriz traspuesta de una matriz A se denota por B y se obtiene
cambiando sus filas por columnas (o viceversa).
 */
public class JavaIntroEjAp19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        
        int [][] matValA = new int[3][3];        
        int [][] matValB = new int[3][3];        
        
        llenaMat(matValA);
        transpMat(matValA, matValB);
        printMat(matValA,"A");
        printMat(matValB,"B");
        
        // Evalua si es antisimetrica
        int anti=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matValA[i][j]==(matValB[i][j] * (-1))) {
                    continue; 
                } else {
                    anti++;
                }    
            }
        }
        
        if (anti == 0 ) {
            System.out.println("La matriz B es ANTISIMETRICA");
        } else {
            System.out.println("La matriz B NO ES ANTISIMETRICA");
        }
            
        
        
        
        
    }
    
    public static void llenaMat( int [][] matVal ) {
        /*for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matVal[i][j]= (int) (Math.random() * 10);
            }
        }*/
        
        matVal[0][0]=0;
        matVal[0][1]=-2;
        matVal[0][2]=4;
        matVal[1][0]=2;
        matVal[1][1]=0;
        matVal[1][2]=2;
        matVal[2][0]=-4;
        matVal[2][1]=-2;
        matVal[2][2]=0;



        
        
    }
    
    public static void printMat( int [][] matVal, String mat ) {
        System.out.println("Matriz " + mat + ":");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            System.out.print("|" + matVal[i][j] + "|");
            }
            System.out.println("");

        }
        System.out.println("");
    }
    
    
    public static void transpMat( int [][] matVal1, int [][] matVal2 ) {
        
        // recorre el vector contabilizando los numeros por cantidad de cifras
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matVal2[j][i]=matVal1[i][j];
            }
        }
    }
    
}