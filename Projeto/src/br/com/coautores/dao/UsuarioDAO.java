package br.com.coautores.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.coautores.model.Usuario;

public class UsuarioDAO implements Serializable {
	
	@Inject
	private EntityManager em;
	
	public boolean autentica(Usuario usuario) {
		
		
		Query query = em.createQuery("from Usuario u where u.login = :pLogin and u.senha = :pSenha");
		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());
		
		boolean encontrado = !query.getResultList().isEmpty();
		
		return encontrado;
	}
	
	public Usuario busca(Usuario usuario) {
		
		
		Query query = em.createQuery("from Usuario u where u.login = :pLogin and u.senha = :pSenha");
		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());
		
		Usuario user = (Usuario) query.getSingleResult();
		
		return user;
	}

}
