package entities;

import java.util.Date;

public class Client {
	
	
	private String nome;
	private String email;
	private Date birthDate;
	
	
	public Client() {
	}


	public Client(String nome, String email, Date birthDate) {
		this.nome = nome;
		this.email = email;
		this.birthDate = birthDate;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
