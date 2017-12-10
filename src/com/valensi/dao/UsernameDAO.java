/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valensi.dao;

import com.valensi.Model.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class UsernameDAO {
        
    EntityManager em;

    public UsernameDAO() {
    }

    public UsernameDAO(EntityManager em) {
        this.em = em;
    }
    
    public User findByUsername(String username) {
        User user = null;
        try {
        Query qUser = em.createQuery("Select u from User u where u.username = :name"); // :name adalah parameter
        qUser.setParameter("name", username);
        user = (User) qUser.getSingleResult();
        } catch (NoResultException nre) {
        //log
        }
        return user;
    }
//        
//    public List<User> findAll() {
//        Query query = em.createQuery("Select e from Employee e");
//        List<User> user = query.getResultList();
//        return user;
//    }
//    
//    public List<User> findByFilter(String filterName) {
//        Query query = em.createQuery("Select u from User u where u.username LIKE CONCAT('%',:filterName,'%')");
//        query.setParameter("filterName", filterName);
//        List<User> user = query.getResultList();
//        return user;
//    }
//    
}
