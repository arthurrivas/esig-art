package com.esig.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_salario")
public class PessoaSalario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE )
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
	private BigDecimal salario;
	@Column(name = "created_at")
	private Date createdAt;
	
	

	public PessoaSalario() {}
	
	public PessoaSalario(Long id, Pessoa pessoa, BigDecimal salario, Date createdAt) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.salario = salario;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "PessoaSalario [id=" + id + ", pessoa=" + pessoa + ", salario=" + salario + ", createdAt=" + createdAt
				+ "]";
	}

}
