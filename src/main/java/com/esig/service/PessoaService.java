package com.esig.service;

import java.util.List;

import javax.inject.Inject;

import com.esig.model.Pessoa;
import com.esig.repository.PessoaRepository;

public class PessoaService {

	@Inject
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> buscarTodasPessoas() {
		return pessoaRepository.buscarTodasPessoas();
	}
	
}
