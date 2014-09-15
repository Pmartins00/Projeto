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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.cooautores.enuns.Enuns.TextoStatus;

@Entity
public class Texto implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="titulo", nullable=false) @Length(min=5, message="{texto.titulo.length}") @NotEmpty(message="{texto.titulo.null}")
	private String titulo;
	
	@Column(name="imagem")
	private String imagem;
	
	@OneToOne(cascade = CascadeType.ALL) @Length(min=5, message="{texto.categoria.length}") @NotEmpty(message="{texto.categoria.null}")
	private Categoria categoria;
	
	@OneToOne(cascade = CascadeType.ALL) @Length(min=5, message="{texto.tema.length}") @NotEmpty(message="{texto.tema.null}")
	private Tema tema;
	
	@OneToOne(cascade = CascadeType.ALL) @Length(min=5, message="{texto.usuario.length}") @NotEmpty(message="{texto.usuario.null}")
	private Usuario usuario;
	
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="texto")
	private List<Paragrafo> paragrafo;
	
	@Column(name="status") @Enumerated(EnumType.STRING)
	private TextoStatus status;
	
	@Column(name="dataCriacao") @Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(name="dataUpdate") @Temporal(TemporalType.TIMESTAMP)
	private Date dataUpdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Paragrafo> getParagrafo() {
		return paragrafo;
	}

	public void setParagrafo(List<Paragrafo> paragrafo) {
		this.paragrafo = paragrafo;
	}

	public TextoStatus isStatus() {
		return status;
	}

	public void setStatus(TextoStatus status) {
		this.status = status;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataUpdate() {
		return dataUpdate;
	}

	public void setDataUpdate(Date dataUpdate) {
		this.dataUpdate = dataUpdate;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
}
