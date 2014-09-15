package br.com.coautores.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Sugestao implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL) @Length(min=5, message="{sugestao.usuario.length}") @NotEmpty(message="{sugestao.usuario.null}")
	private Usuario usuario;
	
	@Column(name="texto")
	private String texto;
	
	@Column(name="dataCriacao") @Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(name="dataUpdate") @Temporal(TemporalType.TIMESTAMP)
	private Date dataUpdate;
	
	public Sugestao() {
		
	}

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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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
