/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaintroej14;


import java.util.Scanner;
/**
 *
 * @author A308862
 * 
 * Crea un vector llamado ‘Equipo’ cuya dimensión sea la cantidad de compañeros de equipo y
 * define su tipo de dato de tal manera que te permita alojar sus nombres más adelante.
 * 
 * 
 */
public class JavaIntroEj14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        String[] Equipo = new String[12];
        
        for (int i = 0; i < 12; i++) {
            System.out.println("Ingrese integrante N°" + (i+1));
            Equipo[i]=lectura.next();
        }

        for (int i = 0; i < 12; i++) {
            System.out.println("Integrante N°" + (i+1) + " " + Equipo[i]);
        }
        
    }
    
}
