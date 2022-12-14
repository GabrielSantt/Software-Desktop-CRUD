package Conn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GabrielSantos
 */
public class JPA {
   private static final  EntityManagerFactory emf= Persistence.createEntityManagerFactory("postgres");

    public EntityManager getEntityManager() {
            return emf.createEntityManager();
    }
    
    
}
