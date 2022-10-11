/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap14;


import java.util.Scanner;
/**
 *
 * @author A308862
 * 
 * Crea una aplicación que a través de una función nos convierta una cantidad de euros
introducida por teclado a otra moneda, estas pueden ser a dólares, yenes o libras. La
función tendrá como parámetros, la cantidad de euros y la moneda a converir que será
una cadena, este no devolverá ningún valor y mostrará un mensaje indicando el cambio
(void).
El cambio de divisas es:
* 0.86 libras es un 1 €
* 1.28611 $ es un 1 €
* 129.852 yenes es un 1 €
 * 
 * 
 */
public class JavaIntroEjAp14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        double cantEuros=0;
        String[] moneda = new String[3];
        
        String mon = "";
        
        do {
            do {
                System.out.println("Ingrese Cantidad de Euros:");
                cantEuros = lectura.nextDouble();
            } while (cantEuros <= 0);
            
            do {
                System.out.println("Ingrese Moneda a Convertir :");
                mon = lectura.next();
            } while (!(mon.equals("Libras") || mon.equals("$") || mon.equals("Yenes")));
            
        } while (cantEuros<=0 && mon.isEmpty());
        
        fnConversion(cantEuros, mon);
        
    }
    
    
    public static void fnConversion(double cantEuros, String mon) {

        int i=0;
        double conversion = 0;
        double[] cambio = new double[3];
        
        cambio[0]=0.86;
        cambio[1]=1.28611;
        cambio[2]=129.852;

        switch(mon){
            case "Libras":
                i=0;
                break;
            case "$":
                i=1;
                break;
            case "Yenes":
                i=2;
                break;
        }        
        
        System.out.println("El cambio de divisas es:");
        
        conversion = cantEuros * cambio[i];
        
        System.out.println(conversion + " " + mon + " equivale a " + cantEuros);
        
                
        return;
    }
    
    
    
}
