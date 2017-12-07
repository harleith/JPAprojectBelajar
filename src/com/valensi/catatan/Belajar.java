/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valensi.catatan;

import com.valensi.Model.Employee;
import com.valensi.Model.Employee;
import static com.valensi.Model.Employee_.name;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class Belajar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAprojectBelajarPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
//        // buat mencari data per orangan
//        String nama = "Joko";
//        Query qName = em.createQuery("Select e from Employee e where e.name= :name");
//        qName.setParameter("name", nama);
//        Employee aName = (Employee) qName.getSingleResult();
//        System.out.println(aName.getName() + " " + aName.getPosition());
//        
         //buat mencari data banyakan
        Query qPro = em.createQuery("Select e from Employee e where e.position= :position");
        qPro.setParameter("position", "programmer");
        List<Employee> progs = qPro.getResultList();
        for (Employee prog : progs) {
            System.out.println(prog.getName() + " " + prog.getPosition());
            
//        String jpql = "Select e from Employee e" 
//                   +   "Where e.postion=:jabatan and e.salary > :gaji";
//        Query qSalary = em.createQuery(jpql);
//        qSalary.setParameter("postion", "programmer");
//        qSalary.setParameter("gaji", 2000000);
//        List<Employee> progSalaries = qSalary.getResultList();
//            for (Employee progSalary : progSalaries) {
//                System.out.println(progSalary.getName() + "" + progSalary.getPosition());
//            }
//        
        
            
        }
        
    }
    }


