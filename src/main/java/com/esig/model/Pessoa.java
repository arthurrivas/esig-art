package com.esig.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String nome;
	private String email;
	private String telefone;
	private String usuario;
	private String cidade;
	private String cep;
	private String endereco;
	private String pais;

	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER)
    private List<PessoaSalario> salarios;
	
	public Pessoa() {
	}

	public Pessoa(Integer id, String nome, String email, String telefone, String usuario, String cidade, String cep, String endereco, String pais, Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.usuario = usuario;
		this.cidade = cidade;
		this.cep = cep;
		this.endereco = endereco;
		this.pais = pais;
		this.dataNascimento = dataNascimento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<PessoaSalario> getSalarios() {
		return salarios;
	}

	public void setSalarios(List<PessoaSalario> salarios) {
		this.salarios = salarios;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", usuario="
				+ usuario + ", cidade=" + cidade + ", cep=" + cep + ", endereco=" + endereco + ", pais=" + pais
				+ ", dataNascimento=" + dataNascimento + ", cargo=" + cargo + ", salarios=" + salarios + "]";
	}
}
