/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sun.jndi.cosnaming.IiopUrl;
import com.valensi.Model.Adress;
import com.valensi.Model.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class PersistTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAprojectBelajarPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        //NEW STATE
        Employee e = new Employee("Jimmy", "Developer", 40000000, 30);
        System.out.println("ID " + e.getId());
        Adress a = new Adress("Wall Street", "New York");
        e.setAdress(a);
        em.persist(a);
        em.persist(e);
        //MANAGED STATE
        System.out.println("ID setelah Persist " +e.getId());
        em.getTransaction().commit();
        em.close();
        // DETACHED STATE
        emf.close();
        
    }
    
}
