package br.com.coautores.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.cooautores.enuns.Enuns.UsuarioPerfil;
import br.com.cooautores.enuns.Enuns.UsuarioStatus;

@Entity
public class Usuario implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="login", unique=true, nullable=false) @Length(min=5, message="{usuario.login.length}") @NotEmpty(message="{usuario.login.null}")
	private String login;
	
	@Column(name="senha", nullable=false) @Length(min=5, message="{usuario.senha.length}") @NotEmpty(message="{usuario.senha.null}")
	private String senha;
	
	@Column(name="nome", nullable=false) @Length(min=5, message="{usuario.nome.length}") @NotEmpty(message="{usuario.login.null}")
	private String nome;
	
	@Column(name="email", unique=true, nullable=false) @Length(min=5, message="{usuario.email.length}") @NotEmpty(message="{usuario.email.null}")
	private String email;
	
	@Column(name="imagem")
	private String imagem;
	
	@Column(name="dataNascimento") @Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name="celular")
	private String celular;
	
	@Column(name="perfil") @Enumerated(EnumType.STRING)
	private UsuarioPerfil perfil;
	
	@Column(name="status") @Enumerated(EnumType.STRING)
	private UsuarioStatus status;
	
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

	public UsuarioPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(UsuarioPerfil perfil) {
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

	public UsuarioStatus isStatus() {
		return status;
	}

	public void setStatus(UsuarioStatus status) {
		this.status = status;
	}
	
}
