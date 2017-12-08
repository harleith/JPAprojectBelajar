/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valensi.app;

import com.valensi.Model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author User
 */
public class UserTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAprojectBelajarPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        
        String rahasia = "rahasia";
        String enkripsi = User.MD5(rahasia);
        
        User user = new User("admin", enkripsi);
        
        em.persist(user);
        
        tx.commit();
        em.close();
        emf.close();
        
    }
    
}
