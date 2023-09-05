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
	private String termoPesquisa;
	
	public PessoaBean(){
	}
	
	@PostConstruct
	public void onCreated() {
		buscaPessoa();
	}		
	
	public void buscaPessoa() {
		if ((termoPesquisa != null && !termoPesquisa.isEmpty())) {
			buscaPessoaPorNome();
		} else {
			buscaTodasPessoas();
		}
	}
	
	public void buscaTodasPessoas() {
		setListaPessoas(pessoaService.buscarTodasPessoas());
	}
	
	public void buscaPessoaPorNome() {
		setListaPessoas(pessoaService.buscaPorNome(termoPesquisa));
	}
	
	public void clicadoCalculaTodosSalarios() {	
		pessoaService.calcularTodosSalarios();
		buscaPessoaPorNome();
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

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoBusca) {
		this.termoPesquisa = termoBusca;
	}
}
