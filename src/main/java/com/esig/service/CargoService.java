package com.esig.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import com.esig.model.Cargo;
import com.esig.model.Vencimento;
import com.esig.repository.CargoRepository;

public class CargoService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CargoRepository cargoRepository;
	
	@Inject 
	private VencimentoService vencimentoService;
	
	public BigDecimal calculaSalarioCargo(Cargo cargo) {
		Set<Vencimento> vencimentos = cargo.getVencimentos();
		
		BigDecimal salario = vencimentoService.calcularSalarioVencimentos(vencimentos);
		
		return salario;
		
	}
	
	public List<Cargo> buscaCargos(){
		return cargoRepository.buscaCargos();
	}
}
