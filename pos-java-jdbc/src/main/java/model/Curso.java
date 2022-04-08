package model;

public class Curso {

	private Long idprimario; // primary key ( tabela pai: tabela dadospessoais)
	private String curso;
	private String tipo;
	private Long idpessoa; // foreing key ( tabela filho: tabela curso)

	public Long getIdprimario() {
		return idprimario;
	}

	public void setIdprimario(Long idprimario) {
		this.idprimario = idprimario;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(Long idpessoa) {
		this.idpessoa = idpessoa;
	}

	@Override
	public String toString() {
		return "Curso [idprimario=" + idprimario + ", curso=" + curso + ", tipo=" + tipo + ", idpessoa=" + idpessoa
				+ "]";
	}

}
