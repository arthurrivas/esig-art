package com.esig.service;

import javax.inject.Inject;

import com.esig.repository.PessoaRepository;
import com.esig.util.Transacional;

public class PessoaService {

	@Inject
	private PessoaRepository pessoaRepository;
	
	public void buscarTodasPessoas() {
		pessoaRepository.buscarTodasPessoas();
	}
	
}
