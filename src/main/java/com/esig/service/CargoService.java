package com.esig.service;

import java.math.BigDecimal;
import java.util.Set;

import javax.inject.Inject;

import com.esig.model.Cargo;
import com.esig.model.Vencimento;
import com.esig.repository.CargoRepository;

public class CargoService {
	
	@Inject 
	private VencimentoService vencimentoService;
	
	public BigDecimal calculaSalarioCargo(Cargo cargo) {
		Set<Vencimento> vencimentos = cargo.getVencimentos();
		
		BigDecimal salario = vencimentoService.calcularSalarioVencimentos(vencimentos);
		
		return salario;
		
	}
	
	
}
