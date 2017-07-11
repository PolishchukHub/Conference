package ua.com.conference.controller;

import java.awt.Menu;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;import ua.com.homeconf.entity.Company;
import ua.com.homeconf.entity.Employees;
import ua.com.homeconf.entity.Sponsor;

public class Main {

	// jpql
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Primary");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		String name = "roma";
		
		try{
			Employees employees = (Employees) manager.createQuery("select e from Employees e where name =:n").setParameter("n", name).getSingleResult();
			Company company = (Company) manager.createQuery("select c from Company c where c.name = 'Microsoft'").getSingleResult();
			
			company.getEmployees().add(employees);
			
			
			manager.merge(company);
			
			
		}catch(NoResultException e){
			System.out.println(1111);
		
		}
		
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

}
