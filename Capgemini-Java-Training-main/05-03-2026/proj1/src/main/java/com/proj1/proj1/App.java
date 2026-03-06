package com.proj1.proj1;
import java.util.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class App 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
//		et.begin();
//		
//				System.out.println("--- 1. INSERTING ---");
//		Employee e1 = new Employee(9, "Sanju Samson", "sAnJu@gmail.com", "2026");
//		Employee e2 = new Employee(18, "Virat Kohli", "virat@gmail.com", "1818");
//		Employee e3 = new Employee(45, "Rohit Sharma", "rohit@gmail.com", "4545");
//	
//		Employee e4=new Employee(56,"Babar Azam","zimbu@gmail.com","0000");
//	em.persist(e1);
//	em.persist(e2);
//	em.persist(e3);
//		em.persist(e4);
//		et.commit();
//	System.out.println("Inserted 3 employees.");

//		// 2. RETRIEVING
//		System.out.println("--- 2. RETRIEVING ---");
//		// Using em.find() to get the employee with Primary Key 18
//		Employee retrievedEmp = em.find(Employee.class, 18);
//		System.out.println("Retrieved Employee: " + retrievedEmp);
//
//		// 3. UPDATING
//		et.begin();
//		System.out.println("--- 3. UPDATING ---");
//		// To update, you simply use the setter methods on an entity that is currently managed by the EntityManager.
//		// Hibernate automatically detects the change and will write an UPDATE query for us!
//		retrievedEmp.setName("VK"); 
//		et.commit();   
//		System.out.println("Updated Kohli's name.");
//      System.out.println("Updated "+em.find(Employee.class, 18));
//
		// 4. DELETING
//		et.begin();
//		System.out.println("--- 4. DELETING ---");
//		// You pass the managed entity object you want to delete to em.remove()
//		Employee toDelete = em.find(Employee.class, 56);
//		em.remove(toDelete);
//		System.out.println("Deleted Zimbabar from the database.");
//		et.commit();
		//JPQL (Java Persistence Query Language)
		//Query to print all the entries
//		et.begin();
//		Query query=em.createQuery("Select e from Employee e ");
//	      List<Employee>list=query.getResultList();
//	      for(Employee e:list)
//	      {
//	   	   System.out.println(e);
//	      }
//			
//		et.commit(); 
//		//Query to print data where name is VK 
//	  et.begin();
//      Query query=em.createQuery("Select e from Employee e where name='VK'");
//      List<Employee>list=query.getResultList();
//      for(Employee e:list)
//      {
//   	   System.out.println(e);
//      }
//		
//et.commit(); 
//		et.begin();
//		//Query to delete data
//		Query query = em.createQuery("DELETE FROM Employee e WHERE e.name = :name");
//		// Bind the value to the parameter
//		query.setParameter("name", "Sanju Samson");
//		// Execute the update
//		int deletedCount = query.executeUpdate();
//		et.commit();
//		
//		//Query to update entry
//		et.begin();
//		Query query = em.createQuery("UPDATE Employee e SET e.mobile = '12345' WHERE e.name = 'VK'");
//		query.executeUpdate();
//		et.commit();
		// Always close your resources!
		em.close();
		emf.close();
	}
}