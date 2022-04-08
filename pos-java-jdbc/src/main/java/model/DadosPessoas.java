package model;


/**
 * 
 * @author O package Model implementa as regras de negócios do projeto Java.
 *
 */
public class DadosPessoas {
	
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "DadosPessoas [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + "]";
	}
	
	

}
