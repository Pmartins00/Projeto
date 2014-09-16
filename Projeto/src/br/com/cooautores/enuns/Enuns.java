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

		EM_EDICAO("Em Edi��o"), LIBERADO("Liberado"), BLOQUEADO("Bloqueado");

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

		INGLES("Ingl�s"), ESPANHOL("Espanhol"), PORTUGUES("Portugu�s"), RUSSO("Russo"), FRANCES("Frances"),
		ALEMAO("Alem�o"), JAPONES("Japon�s"), ITALIANO("Italiano"), TURCO("Turco"), CHINES("Chin�s");

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
