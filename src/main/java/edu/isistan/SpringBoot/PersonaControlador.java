package edu.isistan.SpringBoot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.isistan.SpringBoot.dao.Persona;

@RestController
public class PersonaControlador {
	
	private EntityManagerFactory emf;
	
	public PersonaControlador() {
		emf = Persistence.createEntityManagerFactory("microservicio");
	}
	
	@PutMapping(path="/persona2", consumes="application/json", produces="application/json")
	public Persona put(Persona p) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		return p;
	}
	
	@GetMapping(path="/persona2")
	public List<Persona> getAll() {
		EntityManager em = emf.createEntityManager();
		List<Persona> res = null;
		em.getTransaction().begin();
		res = em.createQuery("SELECT P FROM Persona P").getResultList();
		em.getTransaction().commit();
		return res;
	}
	
	@GetMapping(path="/error")
	public String errorPage(){
		return "le erraste capo";
	}
}
