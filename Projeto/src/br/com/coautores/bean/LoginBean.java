package br.com.coautores.bean;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.coautores.dao.UsuarioDAO;
import br.com.coautores.model.Usuario;
import br.com.cooautores.enuns.Enuns.UsuarioStatus;

@SessionScoped
@Named("loginBean")
public class LoginBean implements Serializable {
	
	Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioDAO dao;
	
	public String autentica() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			boolean aut = dao.autentica(this.usuario);
			
			if (aut) {
				System.out.println("sim");
				
				this.usuario = dao.busca(this.usuario);
				
				if (this.usuario.isStatus() == UsuarioStatus.ATIVO) {
					
					if (this.usuario.getImagem() == null) {
						this.usuario.setImagem("user.jpg");
					}
					context.addMessage(null, new FacesMessage("Sucesso", "Login efetuado com sucesso!"));
					return "home?faces-redirect=true";
					
				} else {
					
					context.addMessage(null, new FacesMessage("Erro", "Usu�rio esta Inativo no sistema, verificar com administrador!"));
					this.usuario = new Usuario();
					return "login?faces-redirect=true";
					
				}
				
			} else {
				this.usuario = new Usuario();
				System.out.println("nao");
				
				context.addMessage(null, new FacesMessage("Erro", "Usu�rio ou senha inv�lidos!"));
				return "login?faces-redirect=true";
			}
		} catch (Exception e) {
			// TODO: handle exception
			context.addMessage(null, new FacesMessage("Erro", "Usu�rio ou senha inv�lidos!"));
			return "login?faces-redirect=true";
		}
		
		
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public boolean isLogado() {
		return this.usuario.getLogin() != null;
	}
	
	public boolean isImagem() {
		if (this.usuario.getImagem() != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public String page() {
		return "login?faces-redirect=true";
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login?faces-redirect=true";
	}
	
	public String cadastro() {
		return "cadastro?faces-redirect=true";
	}

}
