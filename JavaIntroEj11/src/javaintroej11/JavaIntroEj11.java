/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroej11;

/**
 *
 * @author A308862
 */
//////Escribir un programa que procese una secuencia de caracteres ingresada por teclado y
//////terminada en punto, y luego codifique la palabra o frase ingresada de la siguiente manera:
//////	cada vocal se reemplaza por el carácter que se indica en la tabla y el resto de los caracteres
//////	(incluyendo a las vocales acentuadas) se mantienen sin cambios.
//////	
//////	a e i o u
//////	@ # $ % *
//////	
//////	Realice un subprograma que reciba una secuencia de caracteres y retorne la codificación
//////	correspondiente. Utilice la estructura "según" para la transformación.
//////	Por ejemplo, si el usuario ingresa: Ayer, lunes, salimos a las once y 10.
//////		La salida del programa debería ser: @y#r, l*n#s, s@l$m%s @ l@s %nc# y 10.
	

import java.util.Scanner;


public class JavaIntroEj11 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        String frase=" ";
        String fraCodif=" ";

        do {
            //Borrar Pantalla
            
            //Escribir "Ingrese secuencia de caracteres y concluya con un punto (.): "
            System.out.println("Ingrese secuencia de caracteres y concluya con un punto (.): ");
            //Leer frase
            frase = lectura.nextLine();

            // Mientras que la ultima posicion con valor NO sea igual a "." (usar .equals para comparar String (objetos)               
        } while (!(frase.substring(frase.length()-1).equals(".")));
        
        fraCodif = proCodificador(frase);
        System.out.println("La frase codificada es : " + fraCodif);
        
    }
    
    public static String proCodificador(String fra) {
        String fraCod=" ";
        int i;
        String letra = " ";
        for (i = 0; i < fra.length(); i++) {
            letra = fra.substring(i,i+1);
            
            switch (letra) {
                case "A": 
                    letra = "@";
                    break;
                case "E": 
                    letra = "#";
                    break;
                case "I":
                    letra = "$";
                    break;
                case "O":
                    letra = "%";
                    break;
                case "U":
                    letra = "*";
                    break;
            }
            
            fraCod = fraCod.concat(letra);
            
        }
        return fraCod;
    };
    
}
	


