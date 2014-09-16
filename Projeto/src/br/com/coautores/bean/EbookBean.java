package br.com.coautores.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.coautores.model.Ebook;
import br.com.coautores.model.Editora;
import br.com.cooautores.enuns.Enuns.Idiomas;

@RequestScoped
@Named("ebookBean")
public class EbookBean {
	
	private Ebook ebook = new Ebook();
	private Editora editora = new Editora();
	
	public void adiciona() {
		
		System.out.println("adiciona");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso", "teste"));
		
	}

	public Ebook getEbook() {
		return ebook;
	}

	public void setEbook(Ebook ebook) {
		this.ebook = ebook;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	public Idiomas[] getIdiomas() {
		return Idiomas.values();
	}
	
}
