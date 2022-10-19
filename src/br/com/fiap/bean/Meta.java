package br.com.fiap.bean;

import java.sql.Date;
import java.util.Calendar;

public class Meta {

	public Meta(int codigo2, int codigoPessoa2, String nome2, Calendar dataCriacao2, Calendar dataFinal,
			double valor2) {
		// TODO Auto-generated constructor stub
	}
	public int codigo;
	public int codigoPessoa;
	public String nome;
	public Date data1;
	public Calendar dataCriacao;
	public Date data2;
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
	public Date getData1() {
		return data1;
	}
	public void setData1(Date data1) {
		this.data1 = data1;
	}
	public Calendar getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getData2() {
		return data2;
	}
	public void setData2(Date data2) {
		this.data2 = data2;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
