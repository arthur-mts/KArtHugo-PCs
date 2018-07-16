package entities;

import java.sql.Date;
import java.util.List;

public class Usuario {
	private String nome;
	private String cpf;
	private Date nascimento;
	private List<MontagemDeComputador> pcsMontados;
	private String email;

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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public List<MontagemDeComputador> getPcsMontados() {
		return pcsMontados;
	}

	public void setPcsMontados(List<MontagemDeComputador> pcsMontados) {
		this.pcsMontados = pcsMontados;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}