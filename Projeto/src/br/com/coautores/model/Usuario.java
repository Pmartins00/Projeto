package br.com.coautores.model;

import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="cslogin")
	private String login;
	
	@Column(name="cssenha")
	private String senha;
	
	@Column(name="csnome")
	private String nome;
	
	@Column(name="csemail")
	private String email;
	
	@Column(name="csimagem")
	private File imagem;
	
	@Column(name="cddataNascimento")
	private Calendar dataNascimento;
	
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

	public File getImagem() {
		return imagem;
	}

	public void setImagem(File imagem) {
		this.imagem = imagem;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
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
