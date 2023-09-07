package com.esig.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import com.esig.model.TipoVencimento;
import com.esig.model.Vencimento;

public class VencimentoService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public BigDecimal calcularSalarioVencimentos(Set<Vencimento> vencimentos) {
		BigDecimal salario = new BigDecimal(0);
		
		for(Vencimento vencimento : vencimentos) {
			TipoVencimento tipo = vencimento.getTipo();
			
			if(tipo == TipoVencimento.DEBITO) salario = salario.subtract(vencimento.getValor());
			else if(tipo == TipoVencimento.CREDITO) salario = salario.add(vencimento.getValor()); 
			
		}
		return salario;
	}
}
