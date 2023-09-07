package com.esig.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.esig.model.Pessoa;

public class PessoaRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public PessoaRepository() {}
	
	public PessoaRepository(EntityManager manager) {
		this.manager = manager;
	}

	public void salvar(Pessoa pessoa) {
		manager.merge(pessoa);
	}
	
	
	
	
	public List<Pessoa> buscarTodasPessoas() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Pessoa> query = cb.createQuery(Pessoa.class);
        Root<Pessoa> root = query.from(Pessoa.class);

        query.select(root);

        return manager.createQuery(query).getResultList();
    }
	
	public List<Pessoa> buscaPorPessoa(String nome){
		
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteriaQuery = criteriaBuilder.createQuery(Pessoa.class);
		Root<Pessoa> root = criteriaQuery.from(Pessoa.class);
		Predicate predicate = criteriaBuilder.like(
				criteriaBuilder.lower(root.get("nome")), 
				("%"+ nome +"%").toLowerCase()
		);
		criteriaQuery.where(predicate);
		criteriaQuery.select(root);
		TypedQuery<Pessoa> query = manager.createQuery(criteriaQuery);
		
		return query.getResultList();

	}
}
