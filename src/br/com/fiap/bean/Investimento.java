package br.com.fiap.bean;

import java.util.Calendar;

public class Investimento {

	public int codigo;
	public String nome;
	public double valor;
	public String tipo;
	public double valorRendimento;
	public java.sql.Date data;
	public Calendar dataDisponivel;
	
	
	public Investimento(int codigo2, String nome2, double valor2, String tipo2, double valorRendimento2,
			Calendar dataDisponivel2) {
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


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public double getValorRendimento() {
		return valorRendimento;
	}


	public void setValorRendimento(double valorRendimento) {
		this.valorRendimento = valorRendimento;
	}


	public java.sql.Date getData() {
		return data;
	}


	public void setData(java.sql.Date data) {
		this.data = data;
	}


	public Calendar getDataDisponivel() {
		return dataDisponivel;
	}


	public void setDataDisponivel(Calendar dataDisponivel) {
		this.dataDisponivel = dataDisponivel;
	}
	
	
	
}
