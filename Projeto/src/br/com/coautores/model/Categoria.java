package br.com.coautores.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Categoria implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="csnome", nullable=false) @Length(min=5, message="{categoria.nome.length}") @NotEmpty(message="{categoria.nome.null}")
	private String nome;

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
	
}
