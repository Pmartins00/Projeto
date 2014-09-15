package br.com.coautores.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Paragrafo implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL) @Length(min=5, message="{paragrafo.usuario.length}") @NotEmpty(message="{paragrafo.usuario.null}")
	private Usuario usuario;
	
	@ManyToOne() @NotEmpty(message="{paragrafo.texto.null}")
	private Texto texto;
	
	@Column(name="conteudo", nullable=false) @Length(min=5, message="{paragrafo.conteudo.length}") @NotEmpty(message="{paragrafo.conteudo.null}")
	private String conteudo;
	
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
	
}
