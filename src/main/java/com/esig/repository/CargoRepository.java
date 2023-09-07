package com.esig.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.esig.model.Cargo;

public class CargoRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public CargoRepository() {}
	
	public CargoRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	
	public List<Cargo> buscaCargos(){
		CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Cargo> query = cb.createQuery(Cargo.class);
        Root<Cargo> root = query.from(Cargo.class);

        query.select(root);

        return manager.createQuery(query).getResultList();
	}
}
