package br.com.coautores.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Usuario implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="cslogin", unique=true, nullable=false) @Length(min=5) @NotNull
	private String login;
	
	@Column(name="cssenha", nullable=false) @Length(min=5) @NotNull
	private String senha;
	
	@Column(name="csnome", nullable=false) @Length(min=5) @NotNull
	private String nome;
	
	@Column(name="csemail", unique=true, nullable=false) @Length(min=5) @NotNull
	private String email;
	
	@Column(name="csimagem")
	private String imagem;
	
	@Column(name="cddataNascimento") @Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name="cscelular")
	private String celular;
	
	@Column(name="csperfil")
	private String perfil;
	
	@Column(name="cbstatus")
	private boolean status;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Ebook> ebook;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Tema> tema;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public List<Ebook> getEbook() {
		return ebook;
	}

	public void setEbook(List<Ebook> ebook) {
		this.ebook = ebook;
	}

	public List<Tema> getTema() {
		return tema;
	}

	public void setTema(List<Tema> tema) {
		this.tema = tema;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
