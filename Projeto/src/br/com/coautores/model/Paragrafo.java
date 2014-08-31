package br.com.coautores.model;

import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Paragrafo {
	
	@Id @GeneratedValue
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	
	@ManyToOne()
	private Texto texto;
	
	@Column(name="csconteudo")
	private String conteudo;
	
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Texto getTexto() {
		return texto;
	}

	public void setTexto(Texto texto) {
		this.texto = texto;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
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
