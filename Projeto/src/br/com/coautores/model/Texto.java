package br.com.coautores.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Texto {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="cstitulo")
	private String titulo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Categoria categoria;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Tema tema;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="texto")
	private List<Paragrafo> paragrafo;
	
	@Column(name="cbstatus")
	private boolean status;
	
	@Column(name="cddataCriacao")
	private Calendar dataCriacao;
	
	@Column(name="cddataUpdate")
	private Calendar dataUpdate;

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataUpdate() {
		return dataUpdate;
	}

	public void setDataUpdate(Calendar dataUpdate) {
		this.dataUpdate = dataUpdate;
	}
	
}
