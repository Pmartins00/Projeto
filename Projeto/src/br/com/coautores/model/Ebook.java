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
public class Ebook implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="nome", nullable=false) @Length(min=5, message="{ebook.nome.length}") @NotEmpty(message="{ebook.nome.null}")
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL) @Length(min=5, message="{ebook.usuario.length}") @NotEmpty(message="{ebook.usuario.null}")
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL) @Length(min=5, message="{ebook.editora.length}") @NotEmpty(message="{ebook.editora.null}")
	private Editora editora;
	
	@Column(name="idioma", nullable=false) @Length(min=5, message="{ebook.idioma.length}") @NotEmpty(message="{ebook.idioma.null}")
	private String idioma;
	
	@Column(name="imagem")
	private String imagem;
	
	@Column(name="autores", nullable=false) @Length(min=5, message="{ebook.autores.length}") @NotEmpty(message="{ebook.autores.null}")
	private String autores;
	
	@Column(name="file")
	private String file;
	
	@Column(name="dataCriacao") @Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(name="dataUpdate") @Temporal(TemporalType.TIMESTAMP)
	private Date dataUpdate;
	
	@OneToOne(cascade = CascadeType.ALL) @Length(min=5, message="{texto.categoria.length}") @NotEmpty(message="{texto.categoria.null}")
	private Categoria categoria;
	
	@OneToOne(cascade = CascadeType.ALL) @Length(min=5, message="{texto.tema.length}") @NotEmpty(message="{texto.tema.null}")
	private Tema tema;
	
	public Ebook() {
		
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
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
	
}
