package br.com.coautores.model;
import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.coautores.model.Autor;
import br.com.coautores.model.Editora;
import br.com.coautores.model.Usuario;


@Entity
public class Ebook {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="csnome")
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Editora editora;
	
	@Column(name="csidioma")
	private String idioma;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Autor> autores;
	
	@Column(name="cffile")
	private File file;
	
	@Column(name="cddataCriacao")
	private Calendar dataCriacao;
	
	@Column(name="cddataUpdate")
	private Calendar dataUpdate;
	
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

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
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
