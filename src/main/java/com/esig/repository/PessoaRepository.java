package com.esig.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.esig.model.Pessoa;

public class PessoaRepository {
	
	@Inject
	private EntityManager manager;
	
	public PessoaRepository() {}
	
	public PessoaRepository(EntityManager manager) {
		this.manager = manager;
	}

	public List<Pessoa> buscarTodasPessoas() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Pessoa> query = cb.createQuery(Pessoa.class);
        Root<Pessoa> root = query.from(Pessoa.class);

        query.select(root);

        return manager.createQuery(query).getResultList();
    }
	
	public void calcularSalario() {
        
		
    }
}
