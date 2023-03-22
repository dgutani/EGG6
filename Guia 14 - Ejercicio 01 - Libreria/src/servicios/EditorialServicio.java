/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Editorial;
import java.util.List;
import java.util.Scanner;
import javax.persistence.NoResultException;

/**
 *
 * @author usuario
 */
public class EditorialServicio extends JPAController<Editorial>{
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");    
    
    public EditorialServicio() {
        super();
    }
    
    public void crear(Editorial editorial) {
        super.create(editorial);
    }
    
    public void editar(Editorial editorial) {
        super.update(editorial);
    }
    
    public void borrar(Editorial editorial) {
        super.delete(editorial);
    }
    
    public List<Editorial> listarEditoriales(String query) {
        super.connect();
        List<Editorial> editoriales = em.createQuery(query).getResultList();
        super.disconnet();
        return editoriales;
    }
    
    
        
    public void IngresarEditorial() {
        
        //Long idEditorial = 0L;
        String nombreEditorial = "";
        System.out.println("ALTA DE Editorial");
    
        while (nombreEditorial.isEmpty()) {
                System.out.println("Nombre del Editorial a Ingresar:");
                nombreEditorial=leer.next();
                if (nombreEditorial.isEmpty()) {
                    System.out.println("El nombre del Editorial no puede estar vacio !");
                }
        }

        try {
            super.connect();
            Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
                                    .setParameter("nombre", nombreEditorial)
                                    .getSingleResult();
            System.out.println("El Editorial ya existe en la tabla.");
        } catch (NoResultException e) {
            Editorial editorial = new Editorial();
            editorial.setNombre(nombreEditorial);
            editorial.setAlta(true);
            this.crear(editorial);
            System.out.printf("Editorial %s creado!", nombreEditorial);
            System.out.println("");
        } finally {
            super.disconnet();
        }
        
    }
    
    public void BajaEditorial() {
        
        String nombreEditorial = "";
        String rta="";
        System.out.println("BAJA DE Editorial");
        
        while (nombreEditorial.isEmpty()) {
                System.out.println("Nombre del Editorial a Ingresar:");
                nombreEditorial=leer.next();
                if (nombreEditorial.isEmpty()) {
                    System.out.println("El nombre del Editorial no puede estar vacio !");
                }
        }
        
        try {
            super.connect();
            Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
                                    .setParameter("nombre", nombreEditorial)
                                    .getSingleResult();
            while (rta.isEmpty()) {
                System.out.println("El Editorial a Eliminar es :" + editorial.getNombre() + "Baja (S/N)?");
                rta=leer.next();
                if (rta.equals("S")) {
                    this.borrar(editorial);
                    System.out.printf("Editorial %s borrado!", nombreEditorial);
                    System.out.println("");
                }
            }
        } catch (NoResultException e) {
            System.out.printf("El Editorial %s no existe.", nombreEditorial );
            System.out.println("");
            }
        finally {
            super.disconnet();
        }
    }
    
    public void CambiarEditorial() {
        
        String nombreEditorial = "";
        System.out.println("CAMBIO DE Editorial");
        
        while (nombreEditorial.isEmpty()) {
                System.out.println("Nombre del Editorial a Ingresar:");
                nombreEditorial=leer.next();
                if (nombreEditorial.isEmpty()) {
                    System.out.println("El nombre del Editorial no puede estar vacio !");
                }
        }
        
        try {
            super.connect();
            Editorial editorial = (Editorial) em.createQuery("SELECT a FROM Editorial e WHERE e.nombre = :nombre")
                                    .setParameter("nombre", nombreEditorial)
                                    .getSingleResult();
            
            System.out.println("Id del Editorial:" + editorial.getId());
            System.out.println("Nombre del Editorial:" + editorial.getNombre());
            nombreEditorial=leer.next();
            editorial.setNombre(nombreEditorial);
            System.out.println("Estado:" + editorial.getAlta());
            editorial.setAlta(leer.nextBoolean());

            this.editar(editorial);
            
        } catch (NoResultException e) {
            System.out.printf("El editorial %s no existe.", nombreEditorial );
            System.out.println("");
        } finally {
            super.disconnet();
        }
    }
    
    
        public Editorial BuscarEditorialXNombre() {
        
        String nombreEditorial = "";

        while (nombreEditorial.isEmpty()) {
                System.out.println("Nombre de la Editorial?:");
                nombreEditorial=leer.next();
                if (nombreEditorial.isEmpty()) {
                    System.out.println("El nombre de la Editorial no puede estar vacio !");
                }
        }

        Editorial editorialRtrn = new Editorial();
        
        try {
            super.connect();
            Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
                                    .setParameter("nombre", nombreEditorial)
                                    .getSingleResult();
            editorialRtrn = editorial;
        } catch (NoResultException e) {
            System.out.printf("El autor %s no existe.", nombreEditorial );
            System.out.println("");
        } finally {
            super.disconnet();
        }
        return editorialRtrn;
        
    }

    
    
    public Editorial buscarEditorialPorId(Long id) throws Exception {

        try {

            //Validamos
            if (id == null || id <= 0) {
                throw new Exception("Debe indicar un ID valida");
            }

//            return (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.id = :id".setParameter("codigo", id). getSingleResult());
            return (Editorial) em.find(Editorial.class, id);
            
            
        } catch (Exception e) {
            throw e;
        }
    }
    
}
