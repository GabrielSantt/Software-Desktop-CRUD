/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Usuario;

/**
 *
 * @author GabrielSantos
 */
public class UsuarioDAO {

    private final EntityManager em;

    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Usuario user) {

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public List<Usuario> findAll() {
        em.getTransaction().begin();
        List<Usuario> users = null;
        users = em.createQuery(" from Usuario u ").getResultList();
        em.getTransaction().commit();
        em.close();
        return users;
    }

    public Usuario findId(Integer id) {
        em.getTransaction().begin();
        Usuario user = em.find(Usuario.class, id);
        em.getTransaction().commit();
        em.close();
        return user;
    }

    public void deleteById(Integer id) {
        Usuario user = em.find(Usuario.class, id); //Primeiro procura no banco o usuario depois deleta;
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();

    }

    public void update(Usuario user) {
        
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            em.close();
        

    }

}
