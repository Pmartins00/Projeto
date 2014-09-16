package br.com.coautores.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.coautores.dao.DAO;
import br.com.coautores.model.Usuario;
import br.com.coautores.bean.LoginBean;
import br.com.cooautores.enuns.Enuns.UsuarioPerfil;
import br.com.cooautores.enuns.Enuns.UsuarioStatus;

/**
 * @author Poow
 *
 */
@RequestScoped
@Named("cadastroBean")
public class CadastroBean implements Serializable {

	Usuario usuario = new Usuario();
	String senha;
	String nova_senha;

	public String cadastra() {

		System.out.println("adiciona");
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
			this.usuario.setStatus(UsuarioStatus.ATIVO);
			this.usuario.setPerfil(UsuarioPerfil.NORMAL);
			dao.adiciona(this.usuario);
			context.addMessage(null, new FacesMessage("Sucesso", "Usuario cadastrado com sucesso!"));
			
			return "login?faces-redirect=true";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
			context.addMessage(null, new FacesMessage("Erro", e.getMessage()));

			return "cadastro?faces-redirect=true";
		}

	}
	
	public void altera() {
		
		System.out.println("altera");
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			LoginBean loginBean = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
			
			if (loginBean.getUsuario().getSenha().equals(this.senha)) {
				System.out.println("Usuário confirmado!");
				DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
				
				if (!this.nova_senha.equals("")) {
					System.out.println("Altera Senha");
					
					if (this.nova_senha.length() < 5) {
						context.addMessage(null, new FacesMessage("Erro", "Nova senha deve conter no minimo 5 caracteres!"));
					} else {
						loginBean.getUsuario().setSenha(this.nova_senha);
						dao.atualiza(loginBean.getUsuario());
						context.addMessage(null, new FacesMessage("Sucesso", "Usuário e Senha alterados com sucesso!"));
					}
					
				} else {
					dao.atualiza(loginBean.getUsuario());
					context.addMessage(null, new FacesMessage("Sucesso", "Usuario alterado com sucesso!"));
				}
				
			} else {
				System.out.println("A senha digitada não confere!");
				context.addMessage(null, new FacesMessage("Erro", "A senha digitada não confere!"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			context.addMessage(null, new FacesMessage("Erro", e.getMessage()));
		}
		this.senha = "";
		this.nova_senha = "";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNova_senha() {
		return nova_senha;
	}

	public void setNova_senha(String nova_senha) {
		this.nova_senha = nova_senha;
	}

}
