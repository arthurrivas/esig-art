package com.esig.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.esig.model.Pessoa;
import com.esig.model.PessoaSalario;
import com.esig.repository.PessoaRepository;
import com.esig.util.Transacional;

public class PessoaService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaRepository pessoaRepository;
	@Inject
	private CargoService cargoService;
	
	@Inject
	private PessoaSalarioService psService;
	
	@Transacional
	public void salvar(Pessoa pessoa) {
		pessoaRepository.salvar(pessoa);
	}
	
	public List<Pessoa> buscarTodasPessoas() {
		List<Pessoa> pessoas = pessoaRepository.buscarTodasPessoas();
		return pessoas;
	}
	
	public List<Pessoa> buscaPorNome(String nome) {
		return pessoaRepository.buscaPorPessoa(nome);
	}
	
	public void calcularTodosSalarios() {
		List<Pessoa> pessoas = this.buscarTodasPessoas();
		List<PessoaSalario> pessoasSalarios = new ArrayList<>();
		
		pessoas.forEach(item -> {
			pessoasSalarios.add(criaPessoaSalario(item));
		});
		
		psService.salvarTodos(pessoasSalarios);
		
	}
	
	public PessoaSalario criaPessoaSalario(Pessoa pessoa) {
		
		BigDecimal salario = cargoService.calculaSalarioCargo(pessoa.getCargo());
		PessoaSalario pessoaSalario = new PessoaSalario(null, pessoa, salario, new Date());
		
		return pessoaSalario;
	}

	public List<PessoaSalario> ordenaSalariosPorData(List<PessoaSalario> salarios) {
		//	Ordena lista por data de criacao de forma decrescente
		salarios.sort(Comparator.comparing(PessoaSalario::getCreatedAt).reversed());
		return salarios;
	}
	
	public PessoaSalario getUltimoSalario(List<PessoaSalario> salarios) {
		List<PessoaSalario> sortedSalarios = ordenaSalariosPorData(salarios);
		
		return sortedSalarios.isEmpty() ? new PessoaSalario() : salarios.get(0);
		
	}
	
}
