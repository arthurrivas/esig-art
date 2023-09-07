package com.esig.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.esig.model.Cargo;
import com.esig.model.Pessoa;
import com.esig.model.PessoaSalario;
import com.esig.service.CargoService;
import com.esig.service.PessoaService;

@Named
@ManagedBean(name="pessoaBean")
@ViewScoped
public class PessoaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaService pessoaService;
	@Inject
	private CargoService cargoService;
	private CargoConverter cargoConverter;	
	
	private Pessoa pessoa;
	private List<Pessoa> listaPessoas = new ArrayList<>();
	private List<Cargo> listaCargos = new ArrayList<>();
	private String termoPesquisa;
	
	public PessoaBean(){
	}
	
	@PostConstruct
	public void onCreated() {
		buscaCargos();
		cargoConverter = new CargoConverter(getListaCargos());
	}
	
	public void salvarPessoa() {
		pessoaService.salvar(pessoa);
	}
	
	public void resetPessoa() {
		pessoa = new Pessoa();
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
	
	public void buscaCargos() {
		setListaCargos(cargoService.buscaCargos());		
	}
	
	public void clicadoCalculaTodosSalarios() {	
		pessoaService.calcularTodosSalarios();
		buscaPessoaPorNome();
	}
	
	public PessoaSalario getUltimoSalario(List<PessoaSalario> salarios) {
		return pessoaService.getUltimoSalario(salarios);
	}
	
	public boolean selecionadoPessoaEdicao() {
		return (pessoa != null || pessoa.getId() != null);
	}
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public List<Cargo> getListaCargos() {
		return listaCargos;
	}

	public void setListaCargos(List<Cargo> listaCargos) {
		this.listaCargos = listaCargos;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoBusca) {
		this.termoPesquisa = termoBusca;
	}

	public CargoConverter getCargoConverter() {
		return cargoConverter;
	}

	public void setCargoConverter(CargoConverter cargoConverter) {
		this.cargoConverter = cargoConverter;
	}
	
}
