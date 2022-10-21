package br.com.fiap.bean;

import java.util.Calendar;

public class Pessoa {

	public Pessoa(int codigo2, String nome2, String cpf2, Calendar dataNascimento2, String email2) {
		// TODO Auto-generated constructor stub
	}
	
	public int codigo;
	public String nome;
	public String cpf;
	public Calendar dataNascimento;
	public String email;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
