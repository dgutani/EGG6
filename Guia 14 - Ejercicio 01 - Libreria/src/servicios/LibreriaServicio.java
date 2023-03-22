
package servicios;

import java.util.Scanner;



public class LibreriaServicio {
 
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    

    public int Menu() {
        int opc=0;
        
        do {
            System.out.println("===========================");
            System.out.println("-- <<MENU DE LIBRERIA >> --");
            System.out.println("===========================");
            System.out.println(" 1-Alta de Autor");
            System.out.println(" 2-Baja de Autor");
            System.out.println(" 3-Editar Autor");
            System.out.println(" 4-Reporte de Autores");
            System.out.println("---------------------------");
            System.out.println(" 5-Alta Editorial");
            System.out.println(" 6-Baja Editorial");
            System.out.println(" 7-Editar Editorial");
            System.out.println(" 8-Alta de Libros");
            System.out.println(" 9-Baja de Libros");
            System.out.println("10-Editar Libros");
            System.out.println("11-Buscar Libro x ISBN");
            System.out.println("12-Buscar Libro x Titulo");
            System.out.println("13-Buscar Libro x Nombre de Autor");
            System.out.println("14-Buscar Libro x Nombre de Editorial");
            System.out.println(" 0-SALIR");
            opc=leer.nextInt();
        } while ( opc < 0 || opc > 14);
        
        return opc;
        
    }
    
}
