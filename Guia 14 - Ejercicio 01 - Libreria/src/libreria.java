
import servicios.AutorServicio;
import servicios.EditorialServicio;
import servicios.LibroServicio;
import servicios.LibreriaServicio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        LibreriaServicio libreServ = new LibreriaServicio();
        AutorServicio autorServ = new AutorServicio();
        EditorialServicio editorialServ = new EditorialServicio();
        LibroServicio libroServ = new LibroServicio();
        
        int opc=99;
        
        do {
            opc=libreServ.Menu();
    
            switch (opc) {
                case 1:
                    autorServ.IngresarAutor();
                    break;
                case 2:
                    autorServ.BajaAutor();
                    break;
                case 3:
                    autorServ.CambiarAutor();
                    break;
                case 4:
                    autorServ.reporteAutores();
                    break;
                case 5:
                    editorialServ.IngresarEditorial();
                    break;
                case 6:    
                    editorialServ.BajaEditorial();
                    break;
                case 7:
                    editorialServ.CambiarEditorial();
                    break;
                case 8:
                    libroServ.IngresarLibro();
                    break;
                case 9:
                    libroServ.BajaLibro();
                    break;
                case 10:
                    libroServ.CambiarLibro();
                    break;
                case 11:
                    libroServ.BuscarLibroXIsbn();
                    break;
                case 12:
                    libroServ.BuscarLibroXTitulo();
                    break;
                case 13:
                    libroServ.BuscarLibrosXNombreAutor();
                    break;
                case 14:    
                    libroServ.BuscarLibrosXNombreEditorial();
                    break;
                default:
                    break;
            }
        } while (opc > 0);
    }
    
}
