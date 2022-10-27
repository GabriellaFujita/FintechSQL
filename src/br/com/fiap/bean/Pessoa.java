package br.com.fiap.bean;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class Pessoa {


	
	public int codigo;
	public String nome;
	public String cpf;
	public Date data;
	public LocalDate dataNascimento;
	public String email;

	public Pessoa(int codigo2, String nome2, String cpf2, LocalDate dataNascimento2, String email2) {
		// TODO Auto-generated constructor stub
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
				", data=" + data +
				", dataNascimento=" + dataNascimento +
				", email=" + email +
				'}';
	}
}
