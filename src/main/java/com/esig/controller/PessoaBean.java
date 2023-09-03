package com.esig.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import com.esig.model.Pessoa;
import com.esig.model.PessoaSalario;
import com.esig.service.PessoaService;

@Named
@ManagedBean(name="pessoaBean")
@RequestScoped
public class PessoaBean {
	
	@Inject
	private PessoaService pessoaService;
	
	private List<Pessoa> listaPessoas = new ArrayList<>();
	
	public PessoaBean(){
	}
	
	@PostConstruct
	public void onCreated() {
		setListaPessoas(buscaListaPessoas());		
	}	
	
	public List<Pessoa> buscaListaPessoas(){
		return pessoaService.buscarTodasPessoas();
	}
	
	public void clicadoCalculaTodosSalarios() throws InterruptedException {	
		pessoaService.calcularTodosSalarios();
		buscaListaPessoas();
	}
	
	public PessoaSalario getUltimoSalario(List<PessoaSalario> salarios) {
		return pessoaService.getUltimoSalario(salarios);
	}

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
	
}
