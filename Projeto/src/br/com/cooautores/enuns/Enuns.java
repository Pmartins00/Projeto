package br.com.cooautores.enuns;

public class Enuns {

	public enum UsuarioStatus {

		ATIVO("Ativo"), INATIVO("Inativo");

		private String status;

		UsuarioStatus(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

	}

	public enum UsuarioPerfil {

		ADM("Administrador"), MODERADOR("Moderador"), NORMAL("Normal");

		private String perfil;

		UsuarioPerfil(String perfil) {
			this.perfil = perfil;
		}

		public String getPerfil() {
			return perfil;
		}

		public void setPerfil(String perfil) {
			this.perfil = perfil;
		}

	}
	
	public enum TextoStatus {

		EM_EDICAO("Em Edição"), LIBERADO("Liberado"), BLOQUEADO("Bloqueado");

		private String status;

		TextoStatus(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

	}
	
	public enum Idiomas {

		INGLES("Inglês"), ESPANHOL("Espanhol"), PORTUGUES("Português"), RUSSO("Russo"), FRANCES("Frances"),
		ALEMAO("Alemão"), JAPONES("Japonês"), ITALIANO("Italiano"), TURCO("Turco"), CHINES("Chinês");

		private String idioma;

		Idiomas(String idioma) {
			this.idioma = idioma;
		}

		public String getIdioma() {
			return idioma;
		}

		public void setIdioma(String idioma) {
			this.idioma = idioma;
		}

	}
}
