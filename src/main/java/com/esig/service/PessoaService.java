package com.esig.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.esig.model.Pessoa;
import com.esig.model.PessoaSalario;
import com.esig.repository.PessoaRepository;

public class PessoaService {

	@Inject
	private PessoaRepository pessoaRepository;
	@Inject
	private CargoService cargoService;
	
	@Inject
	private PessoaSalarioService psService;
	
	public List<Pessoa> buscarTodasPessoas() {
		return pessoaRepository.buscarTodasPessoas();
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
