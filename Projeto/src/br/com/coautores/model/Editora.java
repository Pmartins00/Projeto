package br.com.coautores.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Editora implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="nome", nullable=false) @Length(min=5, message="{editora.nome.length}") @NotEmpty(message="{editora.nome.null}")
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@Column(name="telefone")
	private String telefone;
	
	public Editora() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
