/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author usuario
 */
public class JPAController<T> {
    protected EntityManagerFactory emf;
    protected EntityManager em;
    
    public JPAController() {
        emf = Persistence.createEntityManagerFactory("LibreriaDEG");
        em = emf.createEntityManager();
    }
    
    protected void connect() {
        if (!em.isOpen()) em = emf.createEntityManager();
    }
    
    protected void disconnet() {
        if (em.isOpen()) em.close();
    }
    
    protected void create(T object) {
        connect();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        disconnet();
    }
    
    protected void update(T object) {
        connect();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        disconnet();
    }
    
    protected void delete(T object) {
        connect();
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
        disconnet();
    }
    
    
}
