package com.esig.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class CargoRepository {

	@Inject
	private EntityManager manager;
	
	public CargoRepository() {}
	
	public CargoRepository(EntityManager manager) {
		this.manager = manager;
	}
}
