package dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import model.Person;


public class UserDAO {
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	public List<Person> findAll(){
		
		return (List<Person>) emf.createEntityManager().createNamedQuery("Person.findAll");
	}

}
