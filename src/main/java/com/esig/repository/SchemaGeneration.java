package com.esig.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SchemaGeneration {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esig");
		
		EntityManager em = emf.createEntityManager();
//		
//		List<Pessoa> list = em.createQuery("from Pessoa", Pessoa.class).getResultList();
//		
//		System.out.println(list);
		
		em.close();
		emf.close();

	}

}
