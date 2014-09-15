package br.com.coautores.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;

import br.com.coautores.dao.DAO;
import br.com.coautores.model.Usuario;

@ManagedBean(name="fileBean")
public class FileBean {
	
	private String arquivo = new String();
	
	private String destination="C:\\Users\\Poow\\git\\Projeto\\Projeto\\WebContent\\resources\\imagens\\usuarios\\";
	
	public void usuario(FileUploadEvent event) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		LoginBean loginBean = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		
		// Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            loginBean.getUsuario().setImagem(event.getFile().getFileName());
            
            DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
            dao.atualiza(loginBean.getUsuario());
            context.addMessage(null, new FacesMessage("Sucesso", event.getFile().getFileName() + " foi adicionada com sucesso."));
            
        } catch (IOException e) {
            e.printStackTrace();
            
            context.addMessage(null, new FacesMessage("Erro", e.getMessage()));
        }
        
		
	}
	
	public void uploadUsuario() {
		
		System.out.println("chegou!");
		System.out.println(this.arquivo);
		
		//File file = new File(this.arquivo);
		
		//System.out.println("Nome Arquivo: "+file.getName());
		//System.out.println("Extenção: "+file.getPath());
		
	}

	public void copyFile(String fileName, InputStream in) {
		try {
			
			ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			File file = new File(  
	                context.getRealPath("/resources/imagens/usuarios/"));
			if (!file.exists()) {
				file.mkdirs();
			}
			
			String filepath = file.getAbsolutePath()+"\\"+fileName;
			
			File file_fim = new File(filepath);
			System.out.println("Path: "+file_fim.getAbsolutePath());
			System.out.println("Path: "+file_fim.getCanonicalPath());
			
			// Salva Imagem no contexto do TOMCAT
			OutputStream out = new FileOutputStream(file_fim);

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();
			
			// Salva Imagem no diretorio do projeto
			out = new FileOutputStream(destination+fileName);

			read = 0;
			bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
}
