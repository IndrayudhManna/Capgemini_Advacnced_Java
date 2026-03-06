package com.proj1.proj1;
import jakarta.persistence.*;

import java.util.*;
public class App2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
//		et.begin();		
//		Customer c = new Customer(1,"Finn");
//		CustomerDetails cd = new CustomerDetails(101,"New Zealand","finnallen@gmail.com","9876543214");
//		Customer c2 = new Customer(2,"Marco");
//		CustomerDetails cd2 = new CustomerDetails(152,"South Africa","marcojansen@gmail.com","5461239874");
//		Customer c3 = new Customer(3,"Varun");
//		CustomerDetails cd3 = new CustomerDetails(296,"India","varunchakravarty@gmail.com","7894569874");
//		c.setCust_det(cd);
//		c2.setCust_det(cd2);
//		em.persist(c);
//		em.persist(c2);
//		c3.setCust_det(cd3);
//		em.persist(c3);
//		et.commit();
		
		
//		et.begin();
//		Customer retrievedCust = em.find(Customer.class, 1);
//		CustomerDetails retrievedCustDet = retrievedCust.getCust_det();
//		System.out.println("Retrieved Customer: " + retrievedCust);		
//		System.out.println("Retrieved Customer Details: " + retrievedCustDet);	
//		et.commit();

		
//		et.begin();
//		retrievedCust.setName("Finn Allen");
//	    retrievedCustDet.setEmail("kiwinner@email.com");	      
//	    System.out.println("Updated: " + em.find(Customer.class, 1));
//	    et.commit();
		
		
//		et.begin();
//	    Customer toDelete = em.find(Customer.class, 2);
//	    em.remove(toDelete);
//	    et.commit();
		
		
		
//		et.begin();
//		Query query=em.createQuery("Select c from Customer c ");
//	    List<Customer>list=query.getResultList();
//		CustomerDetails cd;
//	    for(Customer c:list)
//	    {	
//	    cd=c.getCust_det();
//	    System.out.println(c);
//	   	System.out.println(cd);
//	    }		
//		et.commit(); 
		
		
		
//		et.begin();
//		Query query=em.createQuery("Select c from Customer c where name='Varun'");
//		List<Customer>list=query.getResultList();
//		for(Customer c:list)
//		{
//		System.out.println(c);
//		System.out.println(c.getCust_det());
//		}
//		et.commit(); 
		
		
//		et.begin();
//		Query query = em.createQuery(
//				"UPDATE CustomerDetails cd " +
//						"SET cd.email = 'chakravarun@gmail.com' " +
//						"WHERE cd.customer.name = 'Varun'"
//				);
//		int updatedCount = query.executeUpdate();
//		et.commit();
	}

}