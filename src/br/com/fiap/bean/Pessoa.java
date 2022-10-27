package br.com.fiap.bean;

import java.time.LocalDate;

public class Pessoa {


	
	public int codigo;
	public String nome;
	public String cpf;
	public LocalDate dataNascimento;
	public String email;

	public Pessoa(int codigo, String nome, String cpf, LocalDate dataNascimento, String email) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}

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
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Pessoa{" +
				"codigo=" + codigo +
				", nome=" + nome +
				", cpf=" + cpf +
				", dataNascimento=" + dataNascimento +
				", email=" + email +
				'}';
	}
}
