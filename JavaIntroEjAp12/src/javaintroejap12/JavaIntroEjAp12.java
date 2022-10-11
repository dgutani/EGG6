/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroejap12;


import java.util.Scanner;
/**
 *
 * @author A308862
 * 
 * Realizar un programa que simule el funcionamiento de un dispositivo RS232, este tipo de
    dispositivo lee cadenas enviadas por el usuario. Las cadenas deben llegar con un formato
    fijo: tienen que ser de un máximo de 5 caracteres de largo, el primer carácter tiene que ser
    X y el último tiene que ser una O.
    Las secuencias leídas que respeten el formato se consideran correctas, la secuencia
    especial “&&&&&” marca el final de los envíos (llamémosla FDE), y toda secuencia distinta
    de FDE, que no respete el formato se considera incorrecta.
    Al finalizar el proceso, se imprime un informe indicando la cantidad de lecturas correctas e
    incorrectas recibidas. Para resolver el ejercicio deberá investigar cómo se utilizan las
    siguientes funciones de Java Substring(), Length(), equals().
 */
public class JavaIntroEjAp12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        String cadena = "";
        String FDE = "&&&&&";
        
        int correctas = 0;
        int incorrectas = 0;
        
        do {
        
            System.out.println("Ingrese cadena de 5 bytes:");
            cadena = lectura.nextLine();
            
            if (!cadena.equals(FDE)){
                if (cadena.length()>= 2 && cadena.length() <= 5) {
                    if (cadena.substring(0, 1).equals("X")) {
                        if (cadena.substring(4, 5).equals("O")) {
                            correctas++;
                        } else {
                        incorrectas++;}
                    } else {
                    incorrectas++;}
                } else {
                incorrectas++;
                }
            }
        } while (!cadena.equals(FDE) );

        System.out.println("Correctas : " + correctas + "  Incorrectas : " + incorrectas);

    }
    
}
