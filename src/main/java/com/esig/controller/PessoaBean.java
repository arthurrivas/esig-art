package com.esig.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.esig.model.Pessoa;
import com.esig.repository.PessoaRepository;

@Named
@ManagedBean(name="pessoaBean")
@ViewScoped
public class PessoaBean {
	
	@Inject
	public PessoaRepository pessoaRepository;
	
	private List<Pessoa> listaPessoas = new ArrayList<>();
	
	public PessoaBean(){
	}
	
	@PostConstruct
	public void onCreated() {
		setListaPessoas(buscaListaPessoas());		
	}	
	
	public List<Pessoa> buscaListaPessoas(){
		return pessoaRepository.buscarTodasPessoas();
	}
	
	public void calculaTodosSalarios() {
		// IMPLEMENTS
	}

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
	
}
