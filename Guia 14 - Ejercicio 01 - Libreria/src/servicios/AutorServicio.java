/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Autor;
import java.util.List;
import java.util.Scanner;
import javax.persistence.NoResultException;



/**
 *
 * @author usuario
 */
public class AutorServicio extends JPAController<Autor> {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public AutorServicio() {
        super();
    }
    
    public void crear(Autor autor) {
        super.create(autor);
    }
    
    public void editar(Autor autor) {
        super.update(autor);
    }
    
    public void borrar(Autor autor) {
        super.delete(autor);
    }
    
    public List<Autor> listarAutores(String query) {
        super.connect();
        List<Autor> autores = em.createQuery(query).getResultList();
        super.disconnet();
        return autores;
    }
    
    public void reporteAutores() {
        List<Autor> autores= listarAutores("SELECT a FROM Autor a");
        for (Autor autor: autores) {
            System.out.println("Autor Id: " + autor.getId() + "  Nombre:" + autor.getNombre());
        }
    }
    
    
    
    public void IngresarAutor() {
        
        String nombreAutor = "";
        System.out.println("ALTA DE AUTOR");
    
        while (nombreAutor.isEmpty()) {
                System.out.println("Nombre del Autor a Ingresar:");
                nombreAutor=leer.next();
                if (nombreAutor.isEmpty()) {
                    System.out.println("El nombre del Autor no puede estar vacio !");
                }
        }

        try {
            super.connect();
            Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre")
                                    .setParameter("nombre", nombreAutor)
                                    .getSingleResult();
            System.out.println("El autor ya existe en la tabla.");
        } catch (NoResultException e) {
            Autor autor = new Autor();
            autor.setNombre(nombreAutor);
            autor.setAlta(true);
            this.crear(autor);
            System.out.printf("Autor %s creado!", nombreAutor);
            System.out.println("");
        } finally {
            super.disconnet();
        }
        
    }
    
    public void BajaAutor() {
        
        String nombreAutor = "";
        String rta="";
        System.out.println("BAJA DE AUTOR");
        
        while (nombreAutor.isEmpty()) {
                System.out.println("Nombre del Autor a Ingresar:");
                nombreAutor=leer.next();
                if (nombreAutor.isEmpty()) {
                    System.out.println("El nombre del Autor no puede estar vacio !");
                }
        }
        
        try {
            super.connect();
            Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre")
                                    .setParameter("nombre", nombreAutor)
                                    .getSingleResult();
            while (rta.isEmpty()) {
                System.out.println("El Autor a Eliminar es :" + autor.getNombre() + "Baja (S/N)?");
                rta=leer.next();
                if (rta.equals("S")) {
                    this.borrar(autor);
                    System.out.printf("Autor %s borrado!", nombreAutor);
                    System.out.println("");
                }
            }
        } catch (NoResultException e) {
            System.out.printf("El autor %s no existe.", nombreAutor );
            System.out.println("");
            }
        finally {
            super.disconnet();
        }
    }
    
    public void CambiarAutor() {
        
        String nombreAutor = "";
        System.out.println("CAMBIO DE AUTOR");
        
        while (nombreAutor.isEmpty()) {
                System.out.println("Nombre del Autor a Ingresar:");
                nombreAutor=leer.next();
                if (nombreAutor.isEmpty()) {
                    System.out.println("El nombre del Autor no puede estar vacio !");
                }
        }
        
        try {
            super.connect();
            Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre")
                                    .setParameter("nombre", nombreAutor)
                                    .getSingleResult();
            
            System.out.println("Id del Autor:" + autor.getId());
            System.out.println("Nombre del Autor:" + autor.getNombre());
            nombreAutor=leer.next();
            autor.setNombre(nombreAutor);
            System.out.println("Estado:" + autor.getAlta());
            autor.setAlta(leer.nextBoolean());

            this.editar(autor);
            
        } catch (NoResultException e) {
            System.out.printf("El autor %s no existe.", nombreAutor );
            System.out.println("");
        } finally {
            super.disconnet();
        }
    }
    
    public Autor BuscarAutorXNombre() {
        
        String nombreAutor = "";
        Autor autorRtrn = new Autor();

        // Ejecuta el do/while hasta que el autor a retornar tenga contenido.
        do {
            // Mientras que el nombre del autor este vacio lo va a pedir
            while (nombreAutor.isEmpty()) {
                System.out.println("Nombre del Autor?:");
                nombreAutor=leer.next();
                // Emite el mensaje que no tiene contenido
                if (nombreAutor.isEmpty()) {
                    System.out.println("El nombre del Autor no puede estar vacio !");
                }
            }

            // Con Contenido en nombreAutor hace la busqueda en la tabla Autor
            try {
                // Se conecta a la superclase JPAController
                super.connect();
                // Crea un Entity Manager con el Select a la tabla AUTOR por Nombre devolviendo 1 resultado
                Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre")
                                        .setParameter("nombre", nombreAutor)
                                        .getSingleResult();
                // Asigna el objeto de autor encontrado a el objeto autorRtrn de retorno
                autorRtrn = autor;
            // En caso que no exista objeto con ese nombre Avisa que es inexistente
            } catch (NoResultException e) {
                System.out.printf("El autor %s no existe.", nombreAutor );
                System.out.println("");
            } finally {
                // Se desconecta de la super clase JPAController
                super.disconnet();
            }
        // Si el nombre del Autor esta vacio repite la solicitud de ingreso hasta que encuentre alguno
        } while (autorRtrn.getNombre().isEmpty());
        // Devuelve el autor encontrado.    
        return autorRtrn;
        
    }
}
