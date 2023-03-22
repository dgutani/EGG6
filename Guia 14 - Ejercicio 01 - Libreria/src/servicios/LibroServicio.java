/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.List;
import java.util.Scanner;
import javax.persistence.NoResultException;

/**
 *
 * @author usuario
 */
public class LibroServicio extends JPAController<Libro> {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    AutorServicio autoServ = new AutorServicio();
    EditorialServicio editorialServ = new EditorialServicio();
    
    public LibroServicio() {
        super();
    }
    
    public void crear(Libro libro) {
        super.create(libro);
    }
    
    public void editar(Libro libro) {
        super.update(libro);
    }
    
    public void borrar(Libro libro) {
        super.delete(libro);
    }
    
    public List<Libro> listarLibros(String query) {
        super.connect();
        List<Libro> libros = em.createQuery(query).getResultList();
        super.disconnet();
        return libros;
    }
 
    public void IngresarLibro() {
        
        String titulo = "";
        boolean ok = false;
        System.out.println("ALTA DE LIBRO");
        
        do {
            System.out.println("Titulo del libro a Ingresar:");
            titulo=leer.next();
            if (titulo.isEmpty()) {
                System.out.println("El titulo del Libro no puede estar vacio !");
            }
        } while (titulo.isEmpty());

        try {
            super.connect();
            Libro libro = (Libro) em.createQuery("SELECT x FROM Libro x WHERE x.titulo = :titulo")
                                    .setParameter("titulo", titulo)
                                    .getSingleResult();
            System.out.println("El libro ya existe en la tabla.");
            
        } catch (NoResultException e) {
            Libro libro = new Libro();
            libro.setTitulo(titulo);
            Autor autor = new Autor();
            Editorial editorial = new Editorial();

            Long isbn;
            do {
                System.out.println("Codigo ISBN:");
                isbn = leer.nextLong();
                if (isbn <= 1000000000L) {
                    System.out.println("Codigo ISBN no puede ser menor a 1000000000 !");
                }
            } while (isbn.toString().isEmpty() || isbn <= 1000000000L);
            libro.setIsbn(isbn);

            Integer anio;
            do {
                System.out.println("Año de Edicion:");
                anio = leer.nextInt();
                if (anio <= 1000) {
                    System.out.println("Año de Edición no puede ser menor a 1000 !");
                }
            } while (anio.toString().isEmpty() || anio <= 1000);
            libro.setAnio(anio);

            Integer ejemplares;
            do {
                System.out.println("Cantidad de Ejemplares:");
                ejemplares = leer.nextInt();
                if (ejemplares <= 0) {
                    System.out.println("La cantidad de ejemplares no puede ser <= a 0 !");
                }
            } while (ejemplares.toString().isEmpty() || ejemplares <= 0);
            libro.setEjemplares(ejemplares);

            Integer ejemplaresPrestados;
            do {
                System.out.println("Cantidad de ejemplares Prestados:");
                ejemplaresPrestados = leer.nextInt();
                if (ejemplaresPrestados <= 0) {
                    System.out.println("La cantidad de ejemplares Prestados no puede ser <= a 0 !");
                }
            } while (ejemplaresPrestados.toString().isEmpty() || ejemplaresPrestados <= 0);
            libro.setEjemplaresPrestados(ejemplaresPrestados);

            libro.setEjemplaresRestantes(libro.getEjemplares() - libro.getEjemplaresPrestados());
            libro.setAlta(true);
            // Busca el autor del libro a crear
            autor=autoServ.BuscarAutorXNombre();
            libro.setAutor(autor);
            
            // Busca la editorial del libro a crear
            editorial=editorialServ.BuscarEditorialXNombre();
            libro.setEditorial(editorial);
            // Crea el libro
            this.crear(libro);
            System.out.printf("Libro %s creado!", titulo);
            System.out.println("");
        } finally {
            super.disconnet();
        }
        
    }
    
    public void BajaLibro() {
        
        String titulo = "";
        String rta="";
        System.out.println("BAJA DE LIBRO");
        
        while (titulo.isEmpty()) {
                System.out.println("Nombre del Libro a Ingresar:");
                titulo=leer.next();
                if (titulo.isEmpty()) {
                    System.out.println("El nombre del Libro no puede estar vacio !");
                }
        }
        
        try {
            super.connect();
            Libro libro = (Libro) em.createQuery("SELECT x FROM Libro x WHERE x.titulo = :titulo")
                                    .setParameter("titulo", titulo)
                                    .getSingleResult();
            while (rta.isEmpty()) {
                System.out.println("El Autor a Eliminar es : " + libro.getTitulo() + " -  Baja (S/N)?");
                rta=leer.next();
                if (rta.equals("S")) {
                    this.borrar(libro);
                    System.out.printf("Autor %s borrado!", titulo);
                    System.out.println("");
                }
            }
        } catch (NoResultException e) {
            System.out.printf("El autor %s no existe.", titulo );
            System.out.println("");
            }
        finally {
            super.disconnet();
        }
    }
    
    public void CambiarLibro() {

        String titulo = "";
        boolean ok = false;
        System.out.println("EDITAR LIBRO");
        
        do {
            System.out.println("Titulo del libro a editar:");
            titulo=leer.next();
            if (titulo.isEmpty()) {
                System.out.println("El titulo del Libro no puede estar vacio !");
            }
        } while (titulo.isEmpty());

        try {
            super.connect();
            Libro libro = (Libro) em.createQuery("SELECT x FROM Libro x WHERE x.titulo = :titulo")
                                    .setParameter("titulo", titulo)
                                    .getSingleResult();
            
            System.out.println("Id                   : " + libro.getId());
            System.out.println("ISBN                 : " + libro.getIsbn());
            System.out.println("Año                  : " + libro.getAnio());
            System.out.println("Ejemplares           : " + libro.getEjemplares());
            System.out.println("Ejemplares Prestados : " + libro.getEjemplaresPrestados());
            System.out.println("Ejemplares Restantes : " + libro.getEjemplaresPrestados());
            System.out.println("Alta                 : " + libro.getAlta());
            //System.out.println("Autor Id             : " + libro.getAutor());
            //System.out.println("Editorial Id         : " + libro.getEditorial());
            
            Long isbn;
            do {
                System.out.println("Codigo ISBN:");
                isbn = leer.nextLong();
                if (isbn <= 1000000000L) {
                    System.out.println("Codigo ISBN no puede ser menor a 1000000000 !");
                }
            } while (isbn.toString().isEmpty() || isbn <= 1000000000L);
            libro.setIsbn(isbn);

            Integer anio;
            do {
                System.out.println("Año de Edicion:");
                anio = leer.nextInt();
                if (anio <= 1000) {
                    System.out.println("Año de Edición no puede ser menor a 1000 !");
                }
            } while (anio.toString().isEmpty() || anio <= 1000);
            libro.setAnio(anio);

            Integer ejemplares;
            do {
                System.out.println("Cantidad de Ejemplares:");
                ejemplares = leer.nextInt();
                if (ejemplares <= 0) {
                    System.out.println("La cantidad de ejemplares no puede ser <= a 0 !");
                }
            } while (ejemplares.toString().isEmpty() || ejemplares <= 0);
            libro.setEjemplares(ejemplares);

            Integer ejemplaresPrestados;
            do {
                System.out.println("Cantidad de ejemplares Prestados:");
                ejemplaresPrestados = leer.nextInt();
                if (ejemplaresPrestados <= 0) {
                    System.out.println("La cantidad de ejemplares Prestados no puede ser <= a 0 !");
                }
            } while (ejemplaresPrestados.toString().isEmpty() || ejemplaresPrestados <= 0);
            libro.setEjemplaresPrestados(ejemplaresPrestados);

            libro.setEjemplaresRestantes(libro.getEjemplares() - libro.getEjemplaresPrestados());
            libro.setAlta(true);
            // Busca el autor del libro a crear
            //libro.setAutor(autoServ.BuscarAutorXNombre());
            // Busca la editorial del libro a crear
            //libro.setEditorial(editorialServ.BuscarEditorialXNombre());
            // Crea el libro
            this.editar(libro);
            System.out.printf("Libro %s grabado!", titulo);
            System.out.println("");
            
        } catch (NoResultException e) {
            
            System.out.println("El libro no existe en la tabla.");
            
            
        } finally {
            super.disconnet();
        }
    }
    
    public void BuscarLibroXIsbn() {

        Long isbn = 0L;
        System.out.println("BUSCAR LIBRO X ISBN");
        
        do {
            System.out.println("ISBN del libro a buscar:");
            isbn=leer.nextLong();
            if (isbn.toString().isEmpty()) {
                System.out.println("El ISBN del Libro no puede estar vacio !");
            }
        } while (isbn.toString().isEmpty());

        try {
            super.connect();
            Libro libro = (Libro) em.createQuery("SELECT x FROM Libro x WHERE x.isbn = :isbn")
                                    .setParameter("isbn", isbn)
                                    .getSingleResult();
            
            System.out.println("Id                   : " + libro.getId());
            System.out.println("ISBN                 : " + libro.getIsbn());
            System.out.println("Titulo               : " + libro.getTitulo());
            System.out.println("Año                  : " + libro.getAnio());
            System.out.println("Ejemplares           : " + libro.getEjemplares());
            System.out.println("Ejemplares Prestados : " + libro.getEjemplaresPrestados());
            System.out.println("Ejemplares Restantes : " + libro.getEjemplaresPrestados());
            System.out.println("Alta                 : " + libro.getAlta());
            //System.out.println("Autor Id             : " + libro.getAutor());
            //System.out.println("Editorial Id         : " + libro.getEditorial());
            
            System.out.printf("Libro %s Mostrado!", isbn);
            System.out.println("");
            
        } catch (NoResultException e) {
            System.out.println("El libro no existe en la tabla.");
        } finally {
            super.disconnet();
        }
    }
    
    public void BuscarLibroXTitulo() {

       String titulo = "";
        boolean ok = false;
        System.out.println("BUSCAR LIBRO X TITULO");
        
        do {
            System.out.println("Titulo del libro a buscar:");
            titulo=leer.next();
            if (titulo.isEmpty()) {
                System.out.println("El titulo del Libro no puede estar vacio !");
            }
        } while (titulo.isEmpty());

        try {
            super.connect();
            Libro libro = (Libro) em.createQuery("SELECT x FROM Libro x WHERE x.titulo = :titulo")
                                    .setParameter("titulo", titulo)
                                    .getSingleResult();
            
            System.out.println("Id                   : " + libro.getId());
            System.out.println("ISBN                 : " + libro.getIsbn());
            System.out.println("Titulo               : " + libro.getTitulo());
            System.out.println("Año                  : " + libro.getAnio());
            System.out.println("Ejemplares           : " + libro.getEjemplares());
            System.out.println("Ejemplares Prestados : " + libro.getEjemplaresPrestados());
            System.out.println("Ejemplares Restantes : " + libro.getEjemplaresRestantes());
            System.out.println("Alta                 : " + libro.getAlta());
            //System.out.println("Autor Id             : " + libro.getAutor());
            //System.out.println("Editorial Id         : " + libro.getEditorial());
            
            System.out.printf("Libro %s Mostrado!", titulo);
            System.out.println("");
            
        } catch (NoResultException e) {
            System.out.println("El libro no existe en la tabla.");
        } finally {
            super.disconnet();
        }
    }
    
    public void BuscarLibrosXNombreAutor() {

        String nombreAutor = "";
        System.out.println("BUSCAR LIBROS POR NOMBRE DE AUTOR");
    
        while (nombreAutor.isEmpty()) {
                System.out.println("Nombre del Autor a Buscsar:");
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
            
            try {
                super.connect();
                List<Libro> libros = em.createQuery("SELECT x FROM Libro x WHERE x.autor = :autor")
                                        .setParameter("autor", autor)
                                        .getResultList();
            
                System.out.println("Libros del Autor " + nombreAutor);
                for (Libro libro: libros) {
                    
                    System.out.println("Autor Id: " + libro.getAutor().getId()
                                    + " Nombre del Autor: " + libro.getAutor().getNombre()
                                    + " Editorial: " + libro.getEditorial().getNombre()
                                    + " Titulo: " + libro.getTitulo()
                                    + " Año: " + libro.getAnio()
                                    + " Ejemplares: " + libro.getEjemplares()
                                    + " Ejemplares Prestados: " + libro.getEjemplaresPrestados()
                                    + " Ejemplares Restantes: " + libro.getEjemplaresRestantes()
                                    + " ISBN: " + libro.getIsbn()
                                    + " Alta: " + libro.getAlta()
                                    + " Id Libro: " + libro.getId());
                }
                
                System.out.println();
            
            
            } catch (NoResultException e) {
                System.out.println("El libro no existe en la tabla.");
            } finally {
                super.disconnet();
            }
            
        } catch (NoResultException e) {
            System.out.println("El autor no existe en la tabla.");
            System.out.println("");
        } finally {
            super.disconnet();
        }
        
    }
        
    public void BuscarLibrosXNombreEditorial() {

        String nombreEditorial = "";
        System.out.println("BUSCAR LIBROS POR NOMBRE DE EDITORIAL");
    
        while (nombreEditorial.isEmpty()) {
                System.out.println("Nombre de la Editorial a Buscar:");
                nombreEditorial=leer.next();
                if (nombreEditorial.isEmpty()) {
                    System.out.println("El nombre de la Editorial no puede estar vacio !");
                }
        }

        try {
            super.connect();
            Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
                                    .setParameter("nombre", nombreEditorial)
                                    .getSingleResult();
            
            try {
                super.connect();
                List<Libro> libros = em.createQuery("SELECT x FROM Libro x WHERE x.editorial = :editorial")
                                        .setParameter("editorial", editorial)
                                        .getResultList();
            
                System.out.println("Libros de la Editorial " + nombreEditorial);
                for (Libro libro: libros) {
                    
                    System.out.println("Editorial: " + libro.getEditorial().getNombre()
                                    + " Edit.Id: " + libro.getEditorial().getId()
                                    + " Autor Id: " + libro.getAutor().getId()
                                    + " Nombre del Autor: " + libro.getAutor().getNombre()
                                    + " Titulo: " + libro.getTitulo()
                                    + " Año: " + libro.getAnio()
                                    + " Ejemplares: " + libro.getEjemplares()
                                    + " Ejemplares Prestados: " + libro.getEjemplaresPrestados()
                                    + " Ejemplares Restantes: " + libro.getEjemplaresRestantes()
                                    + " ISBN: " + libro.getIsbn()
                                    + " Alta: " + libro.getAlta()
                                    + " Id Libro: " + libro.getId());
                }
                
                System.out.println();
            
            } catch (NoResultException e) {
                System.out.println("El libro no existe en la tabla.");
            } finally {
                super.disconnet();
            }
            
        } catch (NoResultException e) {
            System.out.println("El autor no existe en la tabla.");
            System.out.println("");
        } finally {
            super.disconnet();
        }
        
    }
    
}
