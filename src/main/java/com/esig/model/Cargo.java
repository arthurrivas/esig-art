package com.esig.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String nome;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name = "cargo_vencimento",
        joinColumns = @JoinColumn(name = "cargo_id"),
        inverseJoinColumns = @JoinColumn(name = "vencimento_id")
    )
    private Set<Vencimento> vencimentos = new HashSet<>();
	
	public Cargo() {}
	
	public Cargo(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Vencimento> getVencimentos() {
		return vencimentos;
	}

	public void setVencimentos(Set<Vencimento> vencimentos) {
		this.vencimentos = vencimentos;
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nome=" + nome + ", vencimentos=" + vencimentos + "]";
	}
	
}
