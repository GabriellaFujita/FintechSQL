package br.com.fiap.bean;

import java.util.Calendar;

public class Meta {

	public Meta(int codigo2, int codigoPessoa2, String nome2, Calendar dataCriacao2, Calendar dataFinal,
			double valor2) {
		// TODO Auto-generated constructor stub
	}
	public int codigo;
	public int codigoPessoa;
	public String nome;
	public Calendar dataCriacao;
	public Calendar dataFinal;
	public double valor;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigoPessoa() {
		return codigoPessoa;
	}
	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Calendar getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
