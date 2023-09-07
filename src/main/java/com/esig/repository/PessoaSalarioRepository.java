package com.esig.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.esig.model.PessoaSalario;

public class PessoaSalarioRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public PessoaSalarioRepository() {}
	
	public PessoaSalarioRepository(EntityManager manager) {
		super();
		this.manager = manager;
	}
	
	
	public void salvar(PessoaSalario pessoaSalario) {
		manager.persist(pessoaSalario);
	}
	
}
