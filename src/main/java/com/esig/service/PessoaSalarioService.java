package com.esig.service;

import java.util.List;

import javax.inject.Inject;

import com.esig.model.PessoaSalario;
import com.esig.repository.PessoaSalarioRepository;
import com.esig.util.Transacional;

public class PessoaSalarioService {

	@Inject
	private PessoaSalarioRepository psRepository;
	
	@Transacional
	public void salvarTodos(List<PessoaSalario> pessoasSalarios) {
		for(PessoaSalario ps : pessoasSalarios) {
			psRepository.salvar(ps);
		}
	}
	
}
