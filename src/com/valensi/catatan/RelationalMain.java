/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valensi.catatan;

import com.valensi.Model.Company;
import com.valensi.Model.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class RelationalMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAprojectBelajarPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        // NEW STATE
        Company c = em.find(Company.class, 54); // mencari data company
        
        Employee e = new Employee("Bill Smith", "Senior", 800000, 40); // masukin data ke employee
        e.setCompany(c); // employee di set ke company
        em.persist(e); // masukin data ke e (employee)
        
        c.getEmployees().add(e); // masukin data ke array employee
        
        em.merge(c); // di gabungin dari employee ke c
        
        List<Employee> emps = c.getEmployees();
        for (Employee emp : emps) {
            System.out.println(emp.getName());
        }
        
        em.getTransaction().commit(); // buat memastikan data di masukan ke database
        em.close();
        emf.close();
    }
    
}
